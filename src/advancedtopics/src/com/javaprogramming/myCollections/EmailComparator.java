package com.javaprogramming.myCollections;

import java.util.Comparator;

public class EmailComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getEmail().compareTo(employee2.getEmail()) ;
    }
}
