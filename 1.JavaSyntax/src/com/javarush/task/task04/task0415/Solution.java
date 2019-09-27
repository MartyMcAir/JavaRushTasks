package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        String res = "";
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if (c >= (a + b) || b >= (a + c) || a >= (b + c)) {
            res = "Треугольник не существует.";
        } else if ((a + b) > c || (a + c) > b || (b + c) > a) {
            res = "Треугольник существует.";
        }

        System.out.println(res);
    }
}