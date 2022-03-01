package com.javaprogramming.myCollections;

public class Customer implements Comparable<Customer> {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Customer customer) {
        return name.compareTo(customer.name);
    }

    @Override
    public String toString() {
        return " [ " + name +" ] ";
    }
}
