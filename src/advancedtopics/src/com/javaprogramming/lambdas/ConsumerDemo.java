package com.javaprogramming.lambdas;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void show() {
        List<Integer> list = List.of(1,2, 3);
        // Imperative programming -> writing code for how it needs to be done, if/else, switch etc..
        for (var item: list) System.out.print(item + " ");

        // Declarative programming -> writing code for what needs to be done
        System.out.println();
        list.forEach(item -> System.out.print(item + " "));

        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());
        Consumer<String> append2AndPrint = item -> System.out.println(item.toUpperCase() + 2);

        System.out.println();
        List<String> list1 = List.of("a", "b", "c");
        list1.forEach(print.andThen(printUpperCase).andThen(append2AndPrint));
    }
}
