package com.javaprogramming.generics;

public class GenericsMain {
    public static void showGenericsOutput() {
        // var numberList = new GenericList<Integer>();
        // **another way to define generic
        GenericList<Integer> numberList = new GenericList<>();
        numberList.add(2);
        System.out.println(numberList.get(0));;
        var userList = new GenericList<User>();
        userList.add(new User());
        System.out.println(userList.get(0));

        User user1 = new User();
        User user2 = new User();
        user1.setPoints(20);
        user2.setPoints(10);
        int compareValue = user1.compareTo(user2);
        if (compareValue > 0) System.out.println("user1 > user2");
        else if (compareValue < 0) System.out.println("user1 < user2");
        else System.out.println("user1 == user2");

        System.out.println("*********** Max Value ***********");
        System.out.println(Utils.max(30, 50));
        System.out.println(Utils.max(user1, user2));

        System.out.println("*********** Min Value ***********");
        System.out.println(Utils.min(30, 50));
        System.out.println(Utils.min(user1, user2));

        System.out.println("*********** Key Value Pair ***********");
        Utils.print(1, 10);

        System.out.println("*********** Wildcards ***********");
        Utils.printUser(new User(10));
        Utils.printUser(new Instructor(10));
        Utils.printUsers(new GenericList<User>());
        Utils.printUsers(new GenericList<Instructor>());
    }
}
