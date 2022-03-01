package com.javaprogramming.executiveFramework;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

class Quote {
    private final String site;
    private final Double price;

    public Quote() {
        this.site = "";
        this.price = 0d;
    }

    public Quote(String site, Double price) {
        this.site = site;
        this.price = price;
    }

    public String getSite() {
        return site;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "site='" + site + '\'' +
                ", price=" + price +
                '}';
    }
}

public class FlightService {

    private static CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting quote from " + site);

            var random = new Random();
            LongTask.simulate(1_000l + random.nextInt(3_000));
            var price = 100 + random.nextInt(10);

            return new Quote(site, Double.valueOf(price));
        });
    }

    private static List<CompletableFuture<Quote>> getQuotes() {
        var sites = List.of("site1", "site2", "site3");
        return sites.stream()
                .map(site -> getQuote(site))
                .collect(Collectors.toList());
    }

    public static void show() {
        var start = LocalTime.now();
//        getQuote("site1")
//                .thenAccept(System.out::println);
        var futures = getQuotes()
                .stream()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    Duration duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + " ms.");
                });
        LongTask.simulate(10_000l);
    }
}
