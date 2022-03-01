package com.javaprogramming.lambdas;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

    public static void show() {
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> cube = n -> n * n * n;
        UnaryOperator<Integer> increment = n -> ++n;
        UnaryOperator<Integer> decrement = n -> --n;

        int n = 5;
        System.out.println("square of 5: " + square.apply(n));
        System.out.println("cube of 5: " + cube.apply(n));
        System.out.println("increment of 5: " + increment.apply(n));
        System.out.println("decrement of 5: " + decrement.apply(n));

        System.out.println("chaining of UnaryOperator on 5");
        System.out.println("operations include in sequence");
        System.out.println("decrement=4 -> cube=64 -> increment=65 -> square=4225");
        var result = decrement.andThen(cube).andThen(increment).andThen(square).apply(n);
        System.out.println("Result: " + result);
    }
}
