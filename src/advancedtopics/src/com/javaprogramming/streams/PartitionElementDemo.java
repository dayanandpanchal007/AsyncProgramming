package com.javaprogramming.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitionElementDemo {

    public static void show() {
        List<Movie> movies = List.of(
                new Movie("Tumbbad", 100, Genre.HORROR),
                new Movie("Inception", 90, Genre.THRILLER),
                new Movie("Conjuring", 80, Genre.HORROR),
                new Movie("Hello World", 60, Genre.PROGRAMMING),
                new Movie("Hello", 90, Genre.PROGRAMMING),
                new Movie("world Hello", 60, Genre.PROGRAMMING),
                new Movie("Conjuring 2", 80, Genre.HORROR)
        );

        Predicate<Movie> popularMovieFilter = movie -> movie.getLikes() > 80;

        var result = movies.stream()
                .collect(Collectors.partitioningBy(popularMovieFilter));
        System.out.println("result " + result);

        var resultMapping = movies.stream()
                .collect(Collectors.partitioningBy(
                            popularMovieFilter,
                            Collectors.mapping(Movie::getTitle, Collectors.joining(", "))
                        ));
        System.out.println("resultMapping: " + resultMapping);
    }
}
