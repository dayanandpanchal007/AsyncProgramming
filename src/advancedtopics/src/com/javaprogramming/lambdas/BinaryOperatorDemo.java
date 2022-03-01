package com.javaprogramming.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorDemo {

    public static void show() {
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("multiply of 2 * 3: " + multiply.apply(2, 3));
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("square of 3: " + square.apply(3));

        var result = multiply.andThen(square).apply(2, 3);
        System.out.println("multiply and square for 2 & 3: " + result);
    }
}
