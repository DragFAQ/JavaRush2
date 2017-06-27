package com.javarush.task.task27.task2712.kitchen;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString() {
        return Stream.of(Dish.values()).map(Dish::toString).collect(Collectors.joining(", ")).toString();
    }
}
