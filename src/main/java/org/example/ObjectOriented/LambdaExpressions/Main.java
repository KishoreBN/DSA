package org.example.ObjectOriented.LambdaExpressions;

public class Main {
    public static void main(String[] args) {
        /*
            Lambda expressions can be used to provide implementation of an abstract method.
            We can use lambda expressions only in case of functional interfaces.
            Below are the examples.
         */
        ArithmeticOperation sum = (a, b) -> {
            System.out.println(a + b);
        };
        ArithmeticOperation subtract = (a, b) -> {
            System.out.println(a - b);
        };
        sum.operation(1,2);
        subtract.operation(3,1);
    }
}
