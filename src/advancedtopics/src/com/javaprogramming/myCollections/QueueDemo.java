package com.javaprogramming.myCollections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {

    public static void show() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");  // throws exception if the size is full
        System.out.println("1. Queue: " + queue);
        queue.offer("d"); // doesn't throws exception if the size is full
        System.out.println("2. Queue after offer " + queue);
        System.out.println("3. Queue peek[returns null if empty]: " + queue.peek());
        System.out.println("4. Queue element[throws exception if empty]: " + queue.element());
        System.out.println("5. Queue remove[throws exception if empty]: " + queue.remove());
        System.out.println("6. Queue: " + queue);
        System.out.println("7. Queue poll==remove[returns null if empty]: " + queue.poll());
        System.out.println("6. Queue: " + queue);
    }
}
