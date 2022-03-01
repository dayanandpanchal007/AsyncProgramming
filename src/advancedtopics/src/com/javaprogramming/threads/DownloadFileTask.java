package com.javaprogramming.threads;

public class DownloadFileTask implements Runnable {

    DownloadStatus status;

    DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file... " + Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }

        System.out.println("Download file complete for thread " + Thread.currentThread().getName());
    }
}
