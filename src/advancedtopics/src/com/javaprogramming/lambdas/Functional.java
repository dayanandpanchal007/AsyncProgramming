package com.javaprogramming.lambdas;

import java.util.function.Function;

public class Functional {
    public static void show() {
        String actualStr = "key:value";
        Function<String, Integer> strlen = str -> str.length();
        System.out.println(strlen.apply("dayanand"));
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addCurlyBraces = str -> "{" + str + "}";
        System.out.println("actual str: " + actualStr);
        var result1 = replaceColon
                                .andThen(addCurlyBraces)
                                .apply(actualStr);
        System.out.println("transformed str[andThen]: " + result1);
        var result2 = addCurlyBraces.compose(replaceColon).apply(actualStr);
        System.out.println("transformed str[compose]: " + result2);

    }
}
