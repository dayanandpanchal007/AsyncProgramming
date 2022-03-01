package com.javaprogramming.executiveFramework;

import java.util.concurrent.Executors;

public class ExecutiveFrameworkDemo {

    public static void show() {
        var executor = Executors.newFixedThreadPool(4);

        try {
            for (var i = 0; i < 10; i++) {
                executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } finally {
            executor.shutdown();
        }

    }
}
