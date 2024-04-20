## Problem statement 
- Instead of running all tests of a project to see the code coverage using jacoco, we run all the tests of a certain class let say Class-A and generate it's report wa can do this for n number of calsses and generate the report. 
- We generate the reports of Class-A and Class-B and megre their reports to create a new report which will have all the coverage info of both Class-A and Class-B
- This will allow us to geneate reports of indivisual classes instead of running all the tests of a project whenever we fixed some tests.
## Solution-1 (Using Maven Profiles)  
- We can create specific maven profiles for each element and add the jacoco plugin to generate the report for it
- Let say we created three profiles for three specific classes and generated their indivisual reports
- Now we can use the jacoco merge feature to create a new overall report

```
<profiles>
    <profile>
        <id>classA-coverage</id>
        <build>
            <plugins>
                <plugin>
                    <groupId>org.jacoco</groupId>
                    <artifactId>jacoco-maven-plugin</artifactId>
                    <executions>
                        <execution>
                            <id>prepare-agent</id>
                            <goals>
                                <goal>prepare-agent</goal>
                            </goals>
                            <configuration>
                                <includes>
                                    <include>com/example/ClassA.java</include>
                                </includes>
                            </configuration>
                        </execution>
                        <execution>
                            <id>report</id>
                            <phase>prepare-package</phase>
                            <goals>
                                <goal>report</goal>
                            </goals>
                            <configuration>
                                <skip>false</skip>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
    </profile>

    <profile>
        <id>classB-coverage</id>
        <build>
            <plugins>
                <plugin>
                    <groupId>org.jacoco</groupId>
                    <artifactId>jacoco-maven-plugin</artifactId>
                    <executions>
                        <execution>
                            <id>prepare-agent</id>
                            <goals>
                                <goal>prepare-agent</goal>
                            </goals>
                            <configuration>
                                <includes>
                                    <include>com/example/ClassB.java</include>
                                </includes>
                            </configuration>
                        </execution>
                        <execution>
                            <id>report</id>
                            <phase>prepare-package</phase>
                            <goals>
                                <goal>report</goal>
                            </goals>
                            <configuration>
                                <skip>false</skip>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
    </profile>
</profiles>

```
Indivisual profile creation for Class-A and Class-B. Now we can use the profile id to generate the reports for each profile and merge them together
```
mvn clean test -PclassA-coverage
mvn clean test -PclassB-coverage
```
To generate the ovrall report we use the jacoco merge plugin with appropriate configuration 
```
mvn jacoco:merge
```
## Solution-2 (Using Maven Resource Filtering and Property Placeholders)
- When we have multiple number of classes we cann't use the profile approach, we can define Maven properties to specify the classes we want to include for coverage analysis
- Using Maven's resource filtering to inject the property values into the Jacoco plugin configuration dynamically
```
<properties>
    <!-- Any numbre of classes can be added here -->
    <included.classes>com.example.ClassA,com.example.ClassB</included.classes>
</properties>

<build>
    <plugins>
        <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <executions>
                <execution>
                    <id>prepare-agent</id>
                    <goals>
                        <goal>prepare-agent</goal>
                    </goals>
                    <configuration>
                        <!--Usinjg Maven resource filtering to dynamically add classes for the jacoco agent -->
                        <includes>
                            <include>${included.classes}</include>
                        </includes>
                    </configuration>
                </execution>
                <execution>
                    <id>report</id>
                    <phase>prepare-package</phase>
                    <goals>
                        <goal>report</goal>
                    </goals>
                    <configuration>
                        <skip>false</skip>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
Now we can use the jacoco to generate reports for the above mentioned classes
```
mvn clean test jacoco:report
```
> All the mehods provided here can be also done by a bash script

> I don't think any of the above mentioned methods are what you asking for

> Please provide more feedback, and where should I make the changes or more info regarding the deployment environment will be great
