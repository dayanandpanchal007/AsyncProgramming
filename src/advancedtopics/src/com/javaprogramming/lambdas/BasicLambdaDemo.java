package com.javaprogramming.lambdas;

public class BasicLambdaDemo {

    public static void show() {
        System.out.println("********** Lambdas Demo **********");
        greet(new ConsolePrinter());

         // anonymous inner class
         System.out.println("using anonymous inner class");
         greet(new Printer() {
             @Override
             public void print(String message) {
                 System.out.println(message);
             }
         });
        //System.out.println("using lambdas");
        //greet(message -> print(message));
        //greet(message -> print(message));
        System.out.println("using lambdas");
        greet(message -> System.out.println(message));
        System.out.println("using method reference [System.out]");
        greet(System.out::println);
        System.out.println("using method reference [LambdasDemo]");
        greet(message -> print("Hello World!!!!"));
        greet(BasicLambdaDemo::print);
    }

    private static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    private static void print(String message) {
        System.out.println("using class: " + message);
    }
}
