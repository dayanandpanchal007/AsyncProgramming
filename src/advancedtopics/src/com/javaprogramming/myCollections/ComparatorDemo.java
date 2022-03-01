package com.javaprogramming.myCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {

    public static void show() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("b", "e3"));
        employees.add(new Employee("c", "e2"));
        employees.add(new Employee("a", "e1"));
        System.out.println("employees before sorting");
        System.out.println(employees);
        Collections.sort(employees, new EmailComparator());
        System.out.println("employee after sorting");
        System.out.println(employees);
    }
}
