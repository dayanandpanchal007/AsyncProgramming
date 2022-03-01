package com.javaprogramming.myCollections;

import java.util.HashMap;
import java.util.Map;

public class HashTableDemo {

    public static void show() {
        Employee employee1 = new Employee("a", "email1");
        Employee employee2 = new Employee("b", "email2");
        Employee unknown = new Employee("Unknown", "");
        Map<String, Employee> map = new HashMap<>();
        map.put(employee1.getEmail(), employee1);
        map.put(employee2.getEmail(), employee2);
        System.out.println("Map: " + map);
        System.out.println("get employee1: " + map.get("email1"));
        System.out.println("get default if emp doesn't exists: " + map.getOrDefault("abc", unknown));
        System.out.println("contains e2: " + map.containsKey("email2"));
        System.out.println("contains abc2: " + map.containsKey("abc2"));
        map.replace("email1", new Employee("a++", "email1"));
        System.out.println("Map: " + map);

        System.out.println("********** other **********");
        System.out.println("********** keySet **********");
        for (String key: map.keySet()) {
            System.out.println("key: " + key);
        }
        System.out.println("********** entrySet[entries] **********");
        for (var entry: map.entrySet()) {
            System.out.println("entry: " + entry);
        }
        System.out.println("********** entrySet[keys] **********");
        for (var entry: map.entrySet()) {
            System.out.println("entry [key]: " + entry.getKey());
        }
        System.out.println("********** entrySet[values] **********");
        for (var entry: map.entrySet()) {
            System.out.println("entry [value]: " + entry.getValue());
        }
        System.out.println("********** values **********");
        for (var employee: map.values()) {
            System.out.println("values: " + employee);
        }
    }
}
