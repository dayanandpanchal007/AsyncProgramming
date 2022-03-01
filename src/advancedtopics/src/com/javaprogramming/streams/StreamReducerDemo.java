package com.javaprogramming.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamReducerDemo {

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

        System.out.println("Count: " + movies.stream().count());
        System.out.println("anyMatch: " + movies.stream().anyMatch(movie -> movie.getLikes() > 80));
        System.out.println("allMatch: " + movies.stream().allMatch(movie -> movie.getLikes() > 80));
        System.out.println("noneMatch: " + movies.stream().noneMatch(movie -> movie.getLikes() > 100));
        System.out.println("findFirst: " + movies.stream().findFirst().get().getTitle());
        System.out.println("findAny: " + movies.stream().findAny().get().getTitle());
        System.out.println("max: " + movies.stream().max(Comparator.comparing(Movie::getLikes)).get());
        System.out.println("min: " + movies.stream().min(Comparator.comparing(Movie::getLikes)).get());

        // Method#1
        System.out.println("Method#1 -> Optional<Integer>");
        Optional<Integer> sum = movies.stream()
                                    .map(Movie::getLikes)
                                    .reduce(Integer::sum);
                                    // .reduce((a, b) -> a + b);
        System.out.println("sum: " + sum.get());
        System.out.println("sum: " + sum.orElse(0));

        // Method#2
        System.out.println("Method#2 -> without Optional<Integer>");
        int result = movies.stream()
                        .map(Movie::getLikes)
                        .reduce(0, Integer::sum);
        System.out.println("result: " + result);
    }
}
