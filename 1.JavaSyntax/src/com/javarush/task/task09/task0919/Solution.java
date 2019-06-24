package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
//            System.out.println(e);
//            StackTraceElement[] st = e.getStackTrace();
//            for (StackTraceElement elem : st) {
//                System.out.println(elem);
//            }

//            System.out.println(e.getStackTrace()[2]);
//            System.out.println(Thread.currentThread().getStackTrace()[1]);
//            System.out.println(Thread.currentThread().getStackTrace()[1]);
            e.printStackTrace();
        } catch (Exception e) {
//            System.out.println(e);
//            StackTraceElement[] st = e.getStackTrace();
//            for (StackTraceElement elem : st) {
//                System.out.println(elem);
//            }
//            System.out.println(e.getStackTrace()[2]);
//            System.out.println(Thread.currentThread().getStackTrace()[1]);
            e.printStackTrace();
        }
    }

    public static void divideByZero() {
        System.out.println((10 / 0));
    }
}
