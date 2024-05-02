package org.example.practice;
class Demo
    {

        Demo ()
        {

            this("This is invoked due to the parameterized constructor");
        }

        Demo(String str){

            System.out.println(str);

        }
        public static void main(String[] args) {
            Demo d = new Demo();
        }

    }


