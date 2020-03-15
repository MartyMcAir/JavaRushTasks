package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer { // т.е. официант тоже слушатель
    // (Официант) в пакете kitchen, он будет относить заказы назад к столику.
    // Нужно уведомить официанта, что пора забирать заказ с кухни.

    // Cook(Повар) готовит заказы, а Waiter их обрабатывает.
    // Расставь правильно Observer и Observable между Waiter и Cook._ - опять эта непонятная формулировка

    @Override
    public void update(Observable o, Object arg) { // у официанта свой текст
        // Your order: [Water] of Tablet{number=5}
        // Start cooking - Your order: [Water] of Tablet{number=5}
        // Your order: [Water] of Tablet{number=5} was cooked by Amigo

//        String res = arg + "\n" //" of " + o + "\n"
//                + "Start cooking - " + arg + "\n"
//                + arg + " was cooked by "; // непонял где имя повора брать
//        ConsoleHelper.writeMessage(res);
        // надо было вывод в Cook изменить
        ConsoleHelper.writeMessage(arg + " was cooked by " + o + "\n");
    }
}
