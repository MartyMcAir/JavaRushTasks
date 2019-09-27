package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a + b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a - b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
//        return a/b; // 33 / 2 = 16.0
        return (double) a / (double) b; // 33 / 2 = 16.5
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
//        return (num1 * num2) / 100;
        // if (5 * 100) / 100 = 0.5 т.е. 5 от 100 это 5%
        return ((double)a * (double)b) / 100; // возвращать b процентов от числа a
    }

    public static void main(String[] args) {
//        System.out.println(Calculator.percent(2, 100));
//        System.out.println(Calculator.division(33, 2));
    }
}