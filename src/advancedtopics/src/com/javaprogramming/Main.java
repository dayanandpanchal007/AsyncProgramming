package com.javaprogramming;

import com.javaprogramming.executiveFramework.CompletableFutureDemo;
import com.javaprogramming.executiveFramework.ExecutiveFrameworkDemo;
import com.javaprogramming.executiveFramework.FlightService;
import com.javaprogramming.lambdas.LambdasDemo;
import com.javaprogramming.myCollections.MyCollectionsMain;
import com.javaprogramming.streams.StreamsDemo;
import com.javaprogramming.threads.ThreadDemo;

public class Main {

    public static void main(String[] args) {
        System.out.println("Java main class is running...");

        // Generics
        // GenericsMain.showGenericsOutput();

        // Collections
        // MyCollectionsMain.showMyCollectionsOutput();

        // Lambdas
        // LambdasDemo.show();

        // Streams
        // StreamsDemo.show();

        // Threads
        // ThreadDemo.show();

        // Executive Framework
        // ExecutiveFrameworkDemo.show();

        // CompletableFuture
        // CompletableFutureDemo.show();
        // CompletableFutureDemo.sendEmailSync();
        // CompletableFutureDemo.sendEmailAsync();
        // CompletableFutureDemo.show2();
        // CompletableFutureDemo.show3();
        // CompletableFutureDemo.convertCelsius2Farenheit();
        // CompletableFutureDemo.printPlaylist();
        // CompletableFutureDemo.printPrice();
        // CompletableFutureDemo.multiService();
        FlightService.show();
    }
}
