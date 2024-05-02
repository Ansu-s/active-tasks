package org.example.practice;

class Parent {
    Parent(){
        System.out.println("The default constructor is called");
    }

    void display() {
        System.out.println("Parent's display method");
    }
}

class Child extends Parent {
    Child(){
        super();
    }
    void display() {

        super.display();
        System.out.println("Child's display method");
    }
}
 class Main {
    public static void main(String[] args) {
        Child c = new Child();
        Child d = new Child();
        c.display();
    }
}
class Superclass {
    Superclass() {
        System.out.println("Superclass constructor");
    }
}

class Subclass extends Superclass {
    Subclass() {
        super();
        System.out.println("Subclasss constructor");
    }
}

 class test {
    public static void main(String[] args) {
        Subclasss obj = new Subclasss();
    }
}

