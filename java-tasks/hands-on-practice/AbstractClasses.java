package org.example.practice;

public class AbstractClasses {
    abstract class Animal {
        void eat() {
            System.out.println("Animal is eating.");
        }
    }

    class Dog extends Animal {
        @Override
        void eat() {
            super.eat();
        }
    }

    public static void main(String[] args) {
        AbstractClasses.Dog a = new AbstractClasses().new
                Dog();
        a.eat();
    }
}
abstract class Shape {
    int sides;

    Shape(int sides) {
        this.sides = sides;
        System.out.println(sides);
    }
}

class Triangle extends Shape {
    Triangle() {
        super(3);
    }
    Triangle triangle = new Triangle();
}
