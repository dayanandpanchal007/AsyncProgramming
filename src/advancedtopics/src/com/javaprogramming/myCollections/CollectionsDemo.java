package com.javaprogramming.myCollections;

import com.javaprogramming.generics.GenericList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {

    public static void show() {
        var list = new GenericList<String>();
        list.add("hello");
        list.add("world");
        for (var item: list) {
            System.out.println(item);
        }

        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        Collections.addAll(collection, "d", "e", "f");
        for (var col: collection) {
            System.out.println(col);
        }
        System.out.println(collection);
        System.out.println("Size: " + collection.size());
        System.out.println("Removing 'f' element from collection...");
        collection.remove("f");
        System.out.println(collection);
        System.out.println("Size: " + collection.size());
        System.out.println("isEmpty " + collection.isEmpty());
        System.out.println("Clearing collection...");
        collection.clear();
        System.out.println("isEmpty " + collection.isEmpty());
        Collections.addAll(collection, "a", "b", "c", "d");
        System.out.println("contains 'a' " + collection.contains("a"));
        Object[] objects = collection.toArray(); // converts to array of objects
        String[] strings = collection.toArray(new String[0]); // converts to array of strings

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        System.out.println("Ref. equality [collection == other]");
        System.out.println(collection == other);
        System.out.println("values equality [collection.equals(other)]");
        System.out.println(collection.equals(other));
    }
}
