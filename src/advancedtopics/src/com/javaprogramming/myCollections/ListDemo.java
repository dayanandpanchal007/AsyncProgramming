package com.javaprogramming.myCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

    public static void show() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("1. " + list);
        list.add(0, "!");
        System.out.println("2. " + list);
        Collections.addAll(list, "d", "e", "f", "a", "b", "c");
        System.out.println("3. " + list);
        System.out.println("4. element at 0 " + list.get(0));
        list.set(0, "a-");
        System.out.println("5. replace ele at 0 " + list);
        list.remove(0);
        System.out.println("6. delete ele at 0 " + list);
        System.out.println("7. indexOf 'b' " + list.indexOf("b"));
        System.out.println("8. lastIndexOf 'b' " + list.lastIndexOf("b"));
        System.out.println("9. list from 1 to 3 " + list.subList(1, 4));
        System.out.println("10. original list after subList " + list);


    }
}
