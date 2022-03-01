package com.javaprogramming.threads;

public class DownloadTaskWithoutThread {

    public void run() {
        System.out.println("Downloading... " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download complete for thread " + Thread.currentThread().getName());
    }
}
