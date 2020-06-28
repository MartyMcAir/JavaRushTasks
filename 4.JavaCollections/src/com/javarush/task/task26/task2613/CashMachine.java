package com.javarush.task.task26.task2613;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        // Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] validTwoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator manipulatorByCurrencyCode = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulatorByCurrencyCode.addAmount(Integer.parseInt(validTwoDigits[0]), Integer.parseInt(validTwoDigits[1]));

//        String currencyCode = ConsoleHelper.askCurrencyCode();
//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//        String[] s = ConsoleHelper.getValidTwoDigits(currencyCode);
//        currencyManipulator.addAmount(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

    }


}
