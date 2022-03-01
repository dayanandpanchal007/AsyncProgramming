package com.javaprogramming.streams;

import java.util.List;
import java.util.stream.Collectors;

public class GroupingElementsDemo {

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

        var resultGenre = movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println("resultGenre " + resultGenre);
        var resultCounting = movies.stream()
                                            .collect(Collectors.groupingBy(
                                                    Movie::getGenre,
                                                    Collectors.counting()
                                            ));
        System.out.println("resultCounting " + resultCounting);
        var resultJoining = movies.stream()
                                            .collect(Collectors.groupingBy(
                                                    Movie::getGenre,
                                                    Collectors.mapping(
                                                            Movie::getTitle,
                                                            Collectors.joining(", ")
                                                    )
                                            ));
        System.out.println("resultJoining: " + resultJoining);
    }
}
