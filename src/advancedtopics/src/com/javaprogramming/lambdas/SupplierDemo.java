package com.javaprogramming.lambdas;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void show() {
        Supplier<Double> getRandom = () -> Math.random();
        System.out.println(getRandom.get());
        IntSupplier getIntRandom = () -> (int)Math.ceil(Math.random() * 6);
        System.out.println(getIntRandom.getAsInt());
    }
}
