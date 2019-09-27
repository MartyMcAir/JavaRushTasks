package com.javarush.task.task15.task1508;

/* 
ООП - Перегрузка - убираем лишнее
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
    }

//    public static void print(byte b) {
//        System.out.println("Я буду Java прогером!1");
//    }

//    public static void print(double d) {
//        System.out.println("Я буду Java прогером!2");  // this _ 3
//    }

    public static void print(long l) {
        System.out.println("Я буду Java прогером!"); // this _ 1
    }

//    public static void print(float f) {
//        System.out.println("Я буду Java прогером!4"); // this _ 2
//    }

//    public static void print(char c) {
//        System.out.println("Я буду Java прогером!5");
//    }
}
