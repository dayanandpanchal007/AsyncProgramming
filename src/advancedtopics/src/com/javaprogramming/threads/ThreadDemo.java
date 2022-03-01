package com.javaprogramming.threads;

import com.javaprogramming.generics.List;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

public class ThreadDemo {

    public static void show() {

        /*
        for (var i = 0; i < 5; i++) {
            new DownloadTaskWithoutThread().run();
        }
        */

        /*
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new DownloadTask());
            thread.start();
        }
        */

        /*
        Thread thread = new Thread(new DownloadTask());
        Thread scannerThread = new Thread(new VirusScanner());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scannerThread.start();
         */
/*
        ArrayList<Thread> threads = new ArrayList<>();
        var status = new DownloadStatus();
        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("No. of bytes downloaded:: " + status.getTotalBytes());
 */

        // ******** synchronized collections *************
//        Collection<Integer> collection = new ArrayList<>();
/*
        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("collections " + collection);
 */

        // *********** Concurrent collections **************
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.get(1);
        map.remove(1);
    }
}
