package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.Externalizable;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] arrStr = {'a','b','c','d',};
        String tmp;
        int tmpInt;
        while (true) {
            tmp = reader.readLine();
            if (!tmp.trim().equalsIgnoreCase("exit")) {
                try {
                    if (tmp.contains(".")) { // NumberFormatException
                        print(Double.parseDouble(tmp));
                    } else {
                        tmpInt = Integer.parseInt(tmp);
                        if (tmpInt > 0 & tmpInt < 128) {
                            print(Short.parseShort(tmp));
                        }
                        if (tmpInt <= 0 | tmpInt >= 128) { // NumberFormatException
                            print(Integer.parseInt(tmp));
                        }
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                    print(tmp);
                }
            } else {
                break;
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
