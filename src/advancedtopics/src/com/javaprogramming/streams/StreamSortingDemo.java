package com.javaprogramming.streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class StreamSortingDemo {

    public static void show() {
        List<Movie> movies = List.of(
                new Movie("Tumbbad", 100),
                new Movie("Inception", 90),
                new Movie("Conjuring", 80),
                new Movie("Hello World", 60),
                new Movie("Hello", 90)
        );

        Consumer<Movie> printMovieTile = movie -> System.out.println(movie.getTitle());

        // Method#1
        System.out.println("*** Method#1");
        movies.stream()
                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                .forEach(printMovieTile);

        // Method#2
        System.out.println("Method#2");
        movies.stream()
                .sorted(Comparator.comparing(m -> m.getTitle()))
                .forEach(printMovieTile);

        // Method#3
        System.out.println("Method#3 -> descending order i.e reverse");
        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(printMovieTile);
    }
}
