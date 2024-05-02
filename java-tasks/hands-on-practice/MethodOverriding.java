package org.example.practice;

class Superclasss {
    void display() {
        System.out.println("Superclass display method");
    }
}

class Subclasss extends Superclasss {

    void display(String str) {
        super.display();
        System.out.println("Subclasss display method with String parameter: " + str);
    }
}

 class RUN {
    public static void main(String[] args) {
        Subclasss obj = new Subclasss();
        obj.display("Hello"); //
    }
}

