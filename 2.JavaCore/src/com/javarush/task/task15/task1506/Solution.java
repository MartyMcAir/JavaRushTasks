package com.javarush.task.task15.task1506;

/* 
Что-то лишнее
*/

public class Solution {
    public static void main(String[] args) {
        // Object for all
        // double and float and int for all _ except Number
        // Integer for all _ except short and Number
        // short ony for short
        print((short) 1);
        print((Number) 1); // Object
        print(1);
        print((Integer) 1);
        print((int) 1);

        // Out
//        Это double
//        Это Object
//        Это double
//        Это Integer
//        Это double
    }

    public static void print(Integer i) { // for Integer
        System.out.println("Это Integer");
    }

//    public static void print(int i) {
//        System.out.println("Это Integer");
//    }

//    public static void print(Short i) {
//        System.out.println("Это Object");
//    }

    public static void print(Object i) { // for Number
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

//    public static void print(Double i) {
//        System.out.println("Это double");
//    }

//    public static void print(float i) {
//        System.out.println("Это Double");
//    }
}
