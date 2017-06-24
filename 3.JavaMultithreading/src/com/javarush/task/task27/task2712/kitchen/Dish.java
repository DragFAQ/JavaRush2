package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString() {
        String result = "";

        for (Dish dish : Dish.values()) {
            result += dish;
        }

        return result;
    }
}
