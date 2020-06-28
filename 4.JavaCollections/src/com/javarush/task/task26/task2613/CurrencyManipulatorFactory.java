package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (map.containsKey(currencyCode))
            return map.get(currencyCode);

        CurrencyManipulator newManipulator = new CurrencyManipulator(currencyCode);
        map.put(currencyCode, newManipulator);
        return newManipulator;
    }


}
