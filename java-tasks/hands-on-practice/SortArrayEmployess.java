package org.example.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Employee{
    String name;
    Float salary;

    public Employee(String name, float sal) {
        this.name = name;
        this.salary = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class SortArrayEmployess {
    public static void main(String[] args) {
        int[] ints = {1,2,5,15,1,5,1,244,10,1,10, 0,0,2,0,20, 10,5};
        String[] strings = {"apple","Banana","cat","DDoggy","AAA","aa"};
        int[] ints1 = Arrays.copyOf(ints,ints.length);
        String[] stringArray = {"banana", "apple", "cherry", "date"};
        String[] stringArray1 = {"banana", "apple", "cherry", "date"};

        Arrays.sort(ints1);
        Arrays.sort(strings);
        Arrays.sort(stringArray, Collections.reverseOrder());
        Arrays.sort(stringArray1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        int length = ints1.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = ints1[i];
            ints1[i] = ints1[length - i - 1];
            ints1[length - i - 1] = temp;
        }
        System.out.println(ints1);

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(stringArray1));

        Employee[] employees = {
                new Employee("John", 50000f),
                new Employee("Alice", 60000f),
                new Employee("Bob", 55000f),
                new Employee("David", 52000f)
        };Employee[] emp1 = {
                new Employee("User", 60000f),
                new Employee("TV", 20000f),
                new Employee("Bank", 55000f),
                new Employee("Car", 52000f)
        };

        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Arrays.sort(emp1,(e1,e2)-> e1.name.compareTo(e2.name));
        Arrays.stream(emp1).forEach(employee -> System.out.println(employee));
        for (Employee emps:employees
             ) {
            System.out.println(emps);
        }
    }
}
