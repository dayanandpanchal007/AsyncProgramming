package com.javaprogramming.threads;

public class VirusScanner implements Runnable {

    @Override
    public void run() {
        System.out.println("Scanning started " + Thread.currentThread().getName());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Scan completed " + Thread.currentThread().getName());
    }
}
