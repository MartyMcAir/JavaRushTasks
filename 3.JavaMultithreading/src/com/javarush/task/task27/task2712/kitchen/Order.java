package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order { // заказ блюд _ (порядок - это и есть заказ _ в порядке очереди in order)
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int res = 0;
        for (int i = 0; i < dishes.size(); i++) {
            res += dishes.get(i).getDuration();
        }
        return res;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    // возвращ пустую строку, если нет блюд в заказе, иначе вывод должен быть аналогичным примеру
    // в порядке добавления блюд. Используй ConsoleHelper. _ непонял заче он тут
    @Override
    public String toString() {
//        return dishes.toString();
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet
                + ", cooking time " + getTotalCookingTime() + "min";
    }
}
