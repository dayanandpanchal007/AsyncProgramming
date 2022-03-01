package com.javaprogramming.myCollections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

    public static void show() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b"));
        customers.add(new Customer("c"));
        customers.add(new Customer("a"));
        System.out.println("customers before sort");
        System.out.println(customers);
        Collections.sort(customers);
        System.out.println("customers after sort");
        System.out.println(customers);
    }

}
