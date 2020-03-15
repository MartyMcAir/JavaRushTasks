package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish { // блюда _ указанное время в минутах
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;

    Dish(int duration) { // время приготовления
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() { // Чтоб пользов мог выбрать блюда, нужно их все ему отобразить.
        // "Fish, Steak, Soup, Juice, Water". Формируй строку динамически.
        return Arrays.toString(values()); // значит это мы называем динамически..
    }
}
