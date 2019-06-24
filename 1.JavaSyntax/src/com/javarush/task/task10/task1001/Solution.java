package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0; // int 4 byte _ -2147483648 до 2147483648
        // ___ если a будет (byte)1200 то на выходе будет -80
        // ___ если a будет (byte)128 то на выходе будет -128

        int b = (byte) a + 46; // byte 1 byte _ -128 до 127
        // __ a приведение к byte ничего не изменяет
        // пока a от 0 до 127 счёт понятен

        byte c = (byte) (a * b);   // 46 * 0 _ почему = 0 !?
        // __ тоже приведение к byte ничего не изменяет

        double f = (char) 1234.15; // char 2 byte _ от 0 до 126 _ но примедение к типу char ничего не меняет
        // а если будет к (byte) то на выходе будет -46.0

        long d = (long) (a + f / c + b);  // short от -32768 до 32767
        System.out.println("a: "+a+", b: "+b+", c: "+c+", f: "+f);
        System.out.println(d);   // -1
    }
}