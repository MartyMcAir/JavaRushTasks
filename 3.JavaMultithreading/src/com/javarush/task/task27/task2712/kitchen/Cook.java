package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

// Observer - Deprecated!
// Класс Cook должен быть потомком класса Observable. - т.е. он наблюдатель и наблюдаемый одновременно
public class Cook extends Observable implements Observer { // Tablet создает заказы, а Cook-повар их обрабатывает.
    // Расставь правильно Observer и Observable между Tablet и Cook. - непонял фразу
    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) { // должен выводить на экран строку форматированную согласно заданию.
        // Your order: [Soup] of Tablet{number=5}
        // Start cooking - Your order: [Soup] of Tablet{number=5}
//        String res = "Your order: " + arg + " of " + o + "\n"
//                + "Start cooking - Your order: " + arg;
//        setChanged(); // должен быть вызван метод setChanged.
//        // должен быть вызван метод notifyObservers с текущим заказом в качестве параметра.
//        notifyObservers(o);
//
//        String res = arg + "\n" //" of " + o + "\n"
//                + "Start cooking - " + arg;
//        ConsoleHelper.writeMessage(res);

        ///
        ConsoleHelper.writeMessage("Start cooking - " + arg + "\n");
        setChanged();
        notifyObservers(arg);

    }
}
