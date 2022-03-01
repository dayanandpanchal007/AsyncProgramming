package com.javaprogramming.executiveFramework;

import java.util.concurrent.CompletableFuture;

public class MailService {

    public static void sendSync() {
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }

    public static CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(() -> sendSync());
    }
}
