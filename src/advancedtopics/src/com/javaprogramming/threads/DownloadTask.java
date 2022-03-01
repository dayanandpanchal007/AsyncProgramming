package com.javaprogramming.threads;

public class DownloadTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading... " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download complete for thread " + Thread.currentThread().getName());
    }
}
