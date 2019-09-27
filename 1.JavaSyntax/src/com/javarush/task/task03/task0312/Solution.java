package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    public static int convertToSeconds(int h){
        int m = h*60;
        return m*60;
    }

    public static void main(String[] args) {
        System.out.println(convertToSeconds(3));
        System.out.println(convertToSeconds(8));
    }
}
