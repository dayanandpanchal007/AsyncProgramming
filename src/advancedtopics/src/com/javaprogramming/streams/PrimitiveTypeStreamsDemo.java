package com.javaprogramming.streams;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class PrimitiveTypeStreamsDemo {

    public static void show() {
        IntConsumer printN = n -> System.out.print(n + " ");
        System.out.println("\nof");
        IntStream.of(1,2,3).forEach(printN);

        System.out.println("\nrange(1, 10)");
        IntStream.range(1, 10).forEach(printN);

        System.out.println("\nrangeClosed(1, 10)");
        IntStream.rangeClosed(1, 10).forEach(printN);
    }
}
