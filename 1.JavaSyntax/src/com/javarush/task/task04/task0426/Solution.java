package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String res = "";
        int n = sc.nextInt();
        if (n == 0) {
            res = "ноль";
        } else if (n < 0 && (n % 2) == 0) {
            res = "отрицательное четное число";
        } else if (n < 0 && (n % 2) != 0) {
            res = "отрицательное нечетное число";
        } else if (n > 0 && (n % 2) == 0) {
            res = "положительное четное число";
        } else if (n > 0 && (n % 2) != 0) {
            res = "положительное нечетное число";
        }
        System.out.println(res);
    }
}
