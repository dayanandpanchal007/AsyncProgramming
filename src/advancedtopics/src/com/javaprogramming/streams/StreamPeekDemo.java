package com.javaprogramming.streams;

import java.util.List;

public class StreamPeekDemo {

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
                .filter(movie -> movie.getLikes() > 85)
                .peek(movie -> System.out.println("filtered: " + movie.getTitle()))
                .map(Movie::getTitle)
                .peek(title -> System.out.println("mapped: " + title))
                .forEach(System.out::println);
    }
}
