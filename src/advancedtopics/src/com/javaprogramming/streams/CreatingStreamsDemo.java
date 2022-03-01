package com.javaprogramming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class CreatingStreamsDemo {

    public static void show() {
        List<Number> list = new ArrayList<>();
        list.stream();
        int[] numbers = {1, 2, 3};
        IntConsumer printIntegers = n -> System.out.println(n);
        Consumer<Integer> printN = n -> System.out.println(n);
        Arrays.stream(numbers).forEach(printIntegers);
        Stream.of(1, 2, 3, 4).forEach(n -> System.out.println(n));
        var stream = Stream.generate(() -> Math.random()); // infinite stream is created
        stream
                .limit(3)  // limits the infinite value to 3
                .forEach(n -> System.out.println(n));
        Stream
                .iterate(1, n -> n + 2)  // infinite stream is created
                .limit(3)  // limits to 3
                .forEach(printN);
    }
}
