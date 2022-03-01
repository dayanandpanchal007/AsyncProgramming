package com.javaprogramming.streams;

import java.util.List;
import java.util.function.Predicate;

public class StreamFilterDemo {

    public static void show() {
        List<Movie> movies = List.of(
                new Movie("Tumbbad", 100),
                new Movie("Inception", 90),
                new Movie("Conjuring", 80),
                new Movie("Hello World", 60)
        );

        Predicate<Movie> isPopular = movie -> movie.getLikes() > 85;

        movies.stream()
                .filter(isPopular)
                .forEach(m -> System.out.println(m.getTitle()));
    }
}
