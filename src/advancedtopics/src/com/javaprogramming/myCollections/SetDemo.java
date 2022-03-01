package com.javaprogramming.myCollections;

import java.util.*;

public class SetDemo {

    public static void show() {
        // Set<String> set1 = new HashSet<>();
        // set1.add("sky");
        // set1.add("is");
        // set1.add("blue");
        // set1.add("blue");
        // System.out.println("1. Set1: " + set1);
        //
        // List<String> collection = new ArrayList<>();
        // Collections.addAll(collection, "a", "b", "b", "c", "c", "c");
        // Set<String> set2 = new HashSet<>(collection);
        // System.out.println("2. Set2: " + set2);
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d"));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        set1.addAll(set2);
        System.out.println("Union of s1 and s2: " + set1);

        Set<String> set3 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set4 = new HashSet<>(Arrays.asList("b", "c", "d"));

        System.out.println("Set3: " + set3);
        System.out.println("Set4: " + set4);
        set3.retainAll(set4);
        System.out.println("Intersection of s3 and s4: " + set3);

        Set<String> set5 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set6 = new HashSet<>(Arrays.asList("b", "c", "d"));

        System.out.println("Set5: " + set5);
        System.out.println("Set6: " + set6);
        set5.removeAll(set6);
        System.out.println("Difference of s5 and s6: " + set5);
    }
}
