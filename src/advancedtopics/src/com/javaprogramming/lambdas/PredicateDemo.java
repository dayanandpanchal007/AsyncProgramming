package com.javaprogramming.lambdas;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void show() {
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        Predicate<String> hasLeftAndRightBrace = hasLeftBrace.and(hasRightBrace);
        Predicate<String> hasLeftOrRightBrace = hasLeftBrace.or(hasRightBrace);
        Predicate<String> notHaveLeftAndRightBrace = hasLeftBrace.and(hasRightBrace).negate();

        System.out.println("has left brace for {adf: " + hasLeftBrace.test("{adf"));
        System.out.println("has left and right brace for {a:1}: " + hasLeftAndRightBrace.test("{a:1}"));
        System.out.println("has left or right brace for a:1}: " + hasLeftOrRightBrace.test("a:1}"));
        System.out.println("not have left and right brace for a:1: " + hasLeftOrRightBrace.test("a:1"));
    }
}
