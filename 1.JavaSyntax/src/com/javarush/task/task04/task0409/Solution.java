package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        displayClosestToTen(8, 11);
        displayClosestToTen(7, 14);
    }

    public static void displayClosestToTen(int a, int b) {
        int res = 0, tmpA, tmpB;
    tmpA = 10 - a;
    tmpB = 10 - b;
        if (abs(tmpA) < abs(tmpB)){
        res =a;
    }else{
        res =b;
    }
        System.out.println(res);
}

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}