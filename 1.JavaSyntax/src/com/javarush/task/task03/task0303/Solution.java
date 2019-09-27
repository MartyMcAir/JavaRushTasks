package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        double a = convertEurToUsd(13, 1.63);
        System.out.println(a);
        System.out.println(convertEurToUsd(18, 1.38));

    }

    public static double convertEurToUsd(int eur, double course) {
        return (double) (eur*course);
    }
}
