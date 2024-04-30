- Used a copy constructor of Person to create a deep copy of person object

```java
public class Address {

    String city;
    String pinCode;

    Address(String city, String pinCode) {
        this.city = city;
        this.pinCode = pinCode;
    }

    Address(Address add) {
        this.city = add.city;
        this.pinCode = add.pinCode;
    }  
}
```
```java
public class Person {

    String name;
    int age;
    Address address;

    Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    Person(Person per) {
        this.name = per.name;
        this.age = per.age;
        this.address = per.address;
    }
}
```

```java
public class CopyClass {
    public static void main(String[] args) {
        Address a1 = new Address("Delhi","759110");
        Person p1 = new Person("user",50,a1);

        //shallow copy
        Address a2 = new Address(a1.city, a1.pinCode);
        Person p2 = new Person(p1.name, p1.age, p1.address);

        //deep copy
        Person p3 = new Person(p1);

    }
}
```
