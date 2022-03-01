package com.javaprogramming.generics;

import java.util.Date;

public class User implements Comparable<User> {
    private String name;
    private Date dob;
    private String address;
    private int points;

    public User() {
    }

    public User(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", points='" + points + '\'' +
                '}';
    }

    @Override
    public int compareTo(User user) {
        /*
        if (points < user.points) return -1;
        else if (points > user.points) return 1;
        return 0;
         */
        return points - user.points;
    }
}
