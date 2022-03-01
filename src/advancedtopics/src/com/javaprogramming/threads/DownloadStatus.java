package com.javaprogramming.threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
//    private int totalBytes;
//    private Lock lock = new ReentrantLock();
//    AtomicInteger totalBytes = new AtomicInteger();

    LongAdder totalBytes = new LongAdder();

    public int getTotalBytes() {
//        return totalBytes;
//        return totalBytes.get();
        return totalBytes.intValue();
    }

    public void incrementTotalBytes() {
//        lock.lock();
//        try {
//        totalBytes++;
//        } finally {
//         lock.unlock();
//        }
//        totalBytes++;

//        totalBytes.incrementAndGet();  // ++a
        totalBytes.increment();
    }
}
