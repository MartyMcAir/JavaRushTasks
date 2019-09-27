package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        int min = 30;
        //int secondsAfter15 = 30*60; // 1800
        int secondsAfter15 = getSecondFromMinute(15, 15.30);
        System.out.println(secondsAfter15);
    }

     public static int getSecondFromMinute(double hSt, double hEn){
        double m = hEn- hSt;
        double sec = (m*100)*60;
        return (int) sec;
     }
}