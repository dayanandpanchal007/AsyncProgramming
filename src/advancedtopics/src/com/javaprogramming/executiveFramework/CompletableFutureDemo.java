package com.javaprogramming.executiveFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {

    public static void show() {
        Runnable task1 = () -> System.out.println("Hello World!");
        Supplier<String> task2 = () -> "Supplier:Hello World!";
        var future1 = CompletableFuture.runAsync(task1);
        var future2 = CompletableFuture.supplyAsync(task2);
        try {
            System.out.println(future2.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendEmailSync() {
        MailService.sendSync();
        System.out.println("Hello World!");
    }

    public static void sendEmailAsync() {
        MailService.sendAsync();
        System.out.println("Hello World!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void show2() {
        var future = CompletableFuture.supplyAsync(() -> 1);
//        future.thenRun(() -> {
//            System.out.println("threadName: " + Thread.currentThread().getName());
//            System.out.println("Done");
//        });
//        future.thenRunAsync(() -> {
//            System.out.println("threadName: " + Thread.currentThread().getName());
//            System.out.println("Done");
//        });
        future.thenAccept((result) -> {
            System.out.println("threadName: " + Thread.currentThread().getName());
            System.out.println("Result: " + result);
        });
        future.thenAcceptAsync((result) -> {
            System.out.println("threadName: " + Thread.currentThread().getName());
            System.out.println("Result: " + result);
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void show3() {
        var future = CompletableFuture.supplyAsync(() -> {
            throw new IllegalStateException();
        });

        try {
            // var temperature = future.get();
            var temperature = future.exceptionally(e -> {
                var lastReadTemperature = 8;
                return lastReadTemperature;
            }).get();
            System.out.println("temperature: " + temperature);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static double toFahrenheit(int celsius) {
        return (celsius * 1.8) + 32;
    }

    public static void convertCelsius2Farenheit() {
        var future = CompletableFuture.supplyAsync(() -> 20);
//        try {
//            var result = future
//                    .thenApply((CompletableFutureDemo::toFahrenheit))
//                    .get();
//            System.out.println("Result: " + result);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        future
                .thenApply((CompletableFutureDemo::toFahrenheit))
                .thenAccept(f -> System.out.println("Result: " + f));
    }

    private static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "dayanand@gmail.com");
    }

    private static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }

    public static void printPlaylist() {
        getUserEmailAsync()
                .thenCompose(CompletableFutureDemo::getPlaylistAsync)
                .thenAccept(System.out::println);
    }

    public static void printPrice() {
        var first = CompletableFuture.supplyAsync(() -> "20USD")
                .thenApply(str -> {
                    String s = str.replace("USD", "");
                    return Integer.parseInt(s);
                });
//        var first = CompletableFuture.supplyAsync(() -> 20);
        var second = CompletableFuture.supplyAsync(() -> 0.9);

        first.thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
                .thenAccept(System.out::println);
    }

    public static void multiService() {
        var one = CompletableFuture.supplyAsync(() -> 1);
        var two = CompletableFuture.supplyAsync(() -> 2);
        var thr = CompletableFuture.supplyAsync(() -> 3);

        var all = CompletableFuture.allOf(one, two, thr);
        all.thenRun(() -> {
                    try {
                        System.out.println(one.get());
                        System.out.println(two.get());
                        System.out.println(thr.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    System.out.println("All task completed");
                });
    }
}
