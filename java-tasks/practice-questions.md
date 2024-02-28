## 1. Array Segregation 
In the below approach we are separating even elements to the left and the odd elements to the right. To achieve this we have swapped the
elements if they are not in the position which is even on left and odd on right and we will traverse the array. This approach can be applied to segrigate an array of 0s and 1s as well.  
Time complexity : O(n)  
Space complexity : O(1)    

```java
package org.example;

public class ArraySegration {
    public static void main(String[] args) {
        int array[] = {5, 0, 12, 12, 121, 15, 18, 35, 6, 4, 4};
        segregation(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    static void segregation(int[] arr) {
        int evenElementPosition = 0;
        int oddElementPosition = arr.length - 1;

        while (evenElementPosition < oddElementPosition) {
            if (arr[evenElementPosition] % 2 != 0) {
                if (arr[oddElementPosition] % 2 == 0) {
                    arr[evenElementPosition] = arr[evenElementPosition] + arr[oddElementPosition];
                    arr[oddElementPosition] = arr[evenElementPosition] - arr[oddElementPosition];
                    arr[evenElementPosition] = arr[evenElementPosition] - arr[oddElementPosition];
                } else oddElementPosition--;
            } else evenElementPosition++;
        }
    }
}
```
### Output :
`4 0 12 12 4 6 18 35 15 121 5 `    

Junit Testcase  
````java
package org.example;

import org.junit.jupiter.api.Test;

import static org.example.ArraySegration.segrigation;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArraySegrationTest {
    @Test
    void segrigationTest() {
        int[] testArray = {5, 0, 12, 12, 121, 15, 18, 35, 6, 4, 4};
        int[] expectedArray = {4, 0, 12, 12, 4, 6, 18, 35, 15, 121, 5};
        segrigation(testArray);
        assertNotNull(testArray);
        assertArrayEquals(expectedArray, testArray);
    }
}
````

## 2. Singleton class  

A singleton class can only have one instance any point of program. The singleton class is not thread safe by default we can implement synchronization to make it thread safe.  
To make a class singleton we have to ensure the below 
- Make the constructor of the class private to prevent direct instantiation from outside the class.
- Provide a static method that returns the instance of the class. This method creates the instance if it doesn't exist, or returns the existing instance if it does.
- Ensure thread safety if the singleton is used in a multi-threaded environment, either by using synchronized methods or using the "double-checked locking".  

```java
package org.example;

public class SingletonClass {
    private SingletonClass() {
    }

    private static volatile SingletonClass instance;

    static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                instance = new SingletonClass();
            }
        }
        return instance;
    }
}

class TestSingleton {
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        if (instance1 == instance2) {
            System.out.println("The class is always returning the same instance");
        } else System.out.println("The instances are different");
    }
}
```  
### Output : 
`The class is always returning the same instance`  

## 3. Dependency Injection in Spring 
Dependency injection helps in achieving the below features 
- Loose coupling of elements in the program
- The IOC containers manages the objects and their dependencies
- Increases the modularity and re-usability of the code
- Supports Aspect Oriented Programming  

In the below example we have injected the dependencies of UserEntityRepository and AuthService and now we can have access to the features of their object. Dependency injection is achieved using @Autowired annotation.
```java
package com.example.bookstoreapp.services.impl;

import com.example.bookstoreapp.auth.AuthService;
import com.example.bookstoreapp.models.User;
import com.example.bookstoreapp.repositories.UserEntityRepository;
import com.example.bookstoreapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserEntityRepository userEntityRepository;

  @Autowired
  private AuthService authService;

  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public User createUser(User user) {
    user.setId(System.nanoTime());
    String rawPassword = user.getPassword();
    user.setPassword(passwordEncoder.encode(rawPassword)); // hashing
    UserEntity userEntity = userEntityRepository.save(user.toEntity());
    return new User().fromEntity(userEntity);
  }
  @Override
  public String authenticate(User user) {
    UserEntity entity = userEntityRepository.findByEmail(user.getEmail());
    if(entity == null){
      throw new AppRuntimeException("login failed");
    }
    String encodedPassword = entity.getPassword();
    boolean passwordMatched = passwordEncoder.matches(user.getPassword(), encodedPassword);

    if(passwordMatched){
      user = new User().fromEntity(entity);
      return authService.createAuthenticationContext(user);
    }
    throw new AppRuntimeException("login failed");
  }
}
```
## 4. Annotations in spring-boot @Component, @Service, @Repository 

@Component :
- It is an annotation used for any Spring-managed component.
- It indicates that the annotated class is a Spring component and should be automatically detected during classpath scanning.
- When Spring Boot detects a class annotated with @Component, it creates an instance of that class and registers it as a bean in the Spring IoC (Inversion of Control) container.  

@Service :
- It is a specialization of @Component.
- It indicates that the annotated class is a service layer component in the application.
- Service layer components typically contain business logic and interact with DAOs (Data Access Objects), repositories, or other services.
- It's used to distinguish the service layer classes from other components, providing a clearer structure to the application.  

 @Repository :
- It is also a specialization of @Component.
- It indicates that the annotated class is a repository component in the application.
- Repository components are used to interact with the database or other external data sources.
- They typically encapsulate CRUD (Create, Read, Update, Delete) operations and query logic.
 
### 5. Configuring Datasource in spring boot
To create a datasource bean we need to use the DataSourceBuilder and create a object of and set all the required propertied of it so spring can manage it automatically. 

```java
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/bookstore_db");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }
}
```