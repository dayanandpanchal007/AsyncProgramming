package com.javaprogramming.generics;

public class Utils {

    public static <T extends  Comparable> T max(T first, T second) {
        return first.compareTo(second) > 0 ? first : second;
    }

    public static <T extends Comparable<T>> T min(T first, T second) {
        return first.compareTo(second) < 0 ? first : second;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + " -> " + value);
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    // CAP#01 extends User
    // Instructor class extends User
    public static void printUsers(GenericList<? extends User> users) {
        System.out.println(users);
    }
}
