package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    // просит пользователя выбрать блюдо и добавляет его в список.
    public static List<Dish> getAllDishesForOrder() throws IOException { // непонял, т.к. список находится в Order
        List<Dish> dishes = new ArrayList<>(); // дошло _надо чтоб новый список вернули и там в Order будет присваиват.
        // Выведи список всех блюд и попроси пользователя ввести строку - название блюда.
        System.out.println("Выберете блюдо (а для выхода exit): ");
        writeMessage(Dish.allDishesToString());

        String choice = "";
        do {
            try {
                dishes.add(Dish.valueOf(choice));
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Выбранного блюда нет в списке!");
            }
            ConsoleHelper.writeMessage("Ещё блюдо? : ");
            choice = readString();
        }
        while (!choice.equals("exit"));
        return dishes;
    }
}
