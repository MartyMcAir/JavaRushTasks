package com.javarush.task.task10.task1005;

/* 
Задача №5 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 44; // убрал byte
        int b = 300; // убрал byte
        short c = (short) (b - a);
//        System.out.println("a: "+a+", b: "+b);
        System.out.println(c);
    }
}