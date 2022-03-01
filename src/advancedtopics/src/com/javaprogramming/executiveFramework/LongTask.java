package com.javaprogramming.executiveFramework;

public class LongTask {

    /**
     *
     */
    public static void simulate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param time in ms
     */
    public static void simulate(Long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
