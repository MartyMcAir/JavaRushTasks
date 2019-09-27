package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        String res = "";
        if (month == 12 || month <= 2) { // 12 1 2
            res = "зима";
        } else if (month > 2 && month < 6) { // 3 4 5
            res = "весна";
        } else if (month > 5 && month < 9) { // 6 7 8
            res = "лето";
        } else if (month > 8 && month < 12) { // 9 10 11
            res = "осень";
        }
        System.out.println(res);
    }
}