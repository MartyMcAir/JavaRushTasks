package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) {
        // Добавьте в main создание планшета и создание четырех заказов.
        // создан новый повар и добавлен планшету в качестве наблюдателя с помощью метода addObserver
        Cook cook = new Cook("Tony Stark");  // слушатель
        Waiter waiter = new Waiter();   // слушатель

        // [Immortal, We make future, Iron 1, Iron 2, Iron 3] - перв сортирока
        // [Immortal, Iron 3, Iron 2, We make future, Iron 1] - вторичная сортировка
        // не мой код показывает, тот же результ
        for (int i = 0; i < 1; i++) {
            Tablet tablet = new Tablet(i);
            // должен быть создан новый официант и добавлен повару в качестве наблюдателя с помощью метода addObserver.
            cook.addObserver(waiter);
            tablet.addObserver(cook);
            tablet.createOrder();
        }
    }
}
