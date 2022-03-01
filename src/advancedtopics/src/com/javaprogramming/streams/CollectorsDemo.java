package com.javaprogramming.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsDemo {

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

        Predicate<Movie> likeFilter = movie -> movie.getLikes() > 80;

        var resultList = movies.stream()
                                        .filter(likeFilter)
                                        .collect(Collectors.toList());
        System.out.println("resultList " + resultList);

        var resultSet = movies.stream()
                                        .filter(likeFilter)
                                        .collect(Collectors.toSet());
        System.out.println("resultSet " + resultSet);

        // title as key
        // likes as value
        // if movie object is stored as value then use m -> m or Funcion.identity()
        /*
            var resultMap = movies.stream()
                                        .filter(likeFilter)
                                        .collect(Collectors.toMap(Movie::getTitle, Funcion.identity()));
                                        or
                                        .collect(Collectors.toMap(Movie::getTitle, m -> m));

         */
        var resultMap = movies.stream()
                                        .filter(likeFilter)
                                        .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));
        System.out.println("resultMap " + resultMap);

        var resultSumming = movies.stream()
                                            .filter(likeFilter)
                                            .collect(Collectors.summingInt(Movie::getLikes));
        System.out.println("resultSumming " + resultSumming);

        var resultSummarizing = movies.stream()
                .filter(likeFilter)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println("resultSummarizing " + resultSummarizing);

        var resultDelimiter = movies.stream()
                                            .filter(likeFilter)
                                            .map(Movie::getTitle)
                                            .collect(Collectors.joining(", "));
        System.out.println("resultDelimiter " + resultDelimiter);
    }
}
