package com.javaprogramming.streams;

import java.util.List;

public class StreamUniqueDemo {

    public static void show() {
        List<Movie> movies = List.of(
                new Movie("Tumbbad", 100),
                new Movie("Inception", 90),
                new Movie("Conjuring", 80),
                new Movie("Hello World", 60),
                new Movie("Hello", 90),
                new Movie("world Hello", 60),
                new Movie("Conjuring 2", 80)
        );

        movies.stream()
                .map(Movie::getLikes)
                .distinct()  // returns unique values
                .forEach(System.out::println);
    }
}
