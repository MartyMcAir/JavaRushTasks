package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        double d = (short) 2.50256e2d;   // 250.0
        char c = (byte) 'd';   // d
        short s = (short) 2.22;   // 2
        int i = (int) 150000;   // 18928
        float f = (float) 0.50f;   // 0.0 __
        double result = f + (i / c) - (d * s) - 500e-3;

//        System.out.println("d: " + d + ", c: " + c + ", s: " + s + ", i: " + i + ", f: " + f);
//
//        System.out.println((i / c)); // 189
//        System.out.println((d * s)); // 500.0
//        System.out.println((i / c) - (d * s)); // -311.0
//        System.out.println((i / c) - (d * s) - 500e-3); // -311.5

        System.out.println("result: " + result); // -311.5
    }
}