package com.javaprogramming.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamSlicingDemo {

    public static void show() {
        List<Movie> movies = List.of(
                new Movie("Tumbbad", 100),
                new Movie("Inception", 90),
                new Movie("Conjuring", 80),
                new Movie("Hello World", 60),
                new Movie("Hello", 90)
        );
        Consumer<Movie> printMovieTitle = movie -> System.out.println(movie.getTitle());
        System.out.println("*** skip to 2");
        movies.stream()
                .skip(2)
                .forEach(printMovieTitle);

        System.out.println("*** limit to 2");
        movies.stream()
                .limit(2)
                .forEach(printMovieTitle);

        System.out.println("*** take while likes > 80");
        movies.stream()
                .takeWhile(movie -> movie.getLikes() > 80)
                .forEach(printMovieTitle);

        System.out.println("*** dropWhile likes > 80");
        movies.stream()
                .dropWhile(movie -> movie.getLikes() > 80)
                .forEach(printMovieTitle);
    }
}
