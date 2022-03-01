package com.javaprogramming.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamMapDemo {

    public static void show() {
        List<Movie> movies = List.of(
                new Movie("Tumbbad", 100),
                new Movie("Inception", 90),
                new Movie("Conjuring", 80)
        );

        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(title -> System.out.println(title));

        movies.stream()
                .mapToInt(movie -> movie.getLikes())
                .forEach(likes -> System.out.println(likes));

        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5,6));
//        System.out.println("before flatmap");
//        stream.forEach(list -> System.out.println(list));
        System.out.println("after flatmap");
        stream
                .flatMap(list -> list.stream())
                .forEach(n -> System.out.println(n));
    }
}
