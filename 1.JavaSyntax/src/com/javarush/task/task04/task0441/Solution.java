package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int res = 0, n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        if (n1 == n2 && n1 == n3) {
            res = n1;
        } else if (n1 == n2 && n1 != n3) {
            res = n2;
        } else if (n2 == n3 && n2 != n1) {
            res = n3;
        } else if (n3 == n1 && n3 != n2) {
            res = n3;
        } else if (maxIs(n1, n2, n3) == n1 && minIs(n1, n2, n3) == n2) {
            res = n3;
        } else if (maxIs(n1, n2, n3) == n2 && minIs(n1, n2, n3) == n1) {
            res = n3;
        } else if (maxIs(n1, n2, n3) == n2 && minIs(n1, n2, n3) == n3) {
            res = n1;
        } else if (maxIs(n1, n2, n3) == n3 && minIs(n1, n2, n3) == n2) {
            res = n1;
        } else if (maxIs(n1, n2, n3) == n3 && minIs(n1, n2, n3) == n1) {
            res = n2;
        } else if (maxIs(n1, n2, n3) == n1 && minIs(n1, n2, n3) == n3) {
            res = n2;
        }
        System.out.println(res);
    }

    public static int maxIs(int a, int b, int c) {
        int res = 0;
        if (a > b && a > c) {
            res = a;
        } else if (b > c && b > a) {
            res = b;
        } else if (c > a && c > b) {
            res = c;
        }
//        int max = a >= b && a >= c && a >= d ? a : (b >= a && b >= c && b >= d ? b : (c >= a && c >= b && c >= d ? c : d));
//        System.out.println(max); // тернарный
//        System.out.println("количество дней в году: " +
//                (i % 4 == 0 ? i % 100 == 0 ? i % 400 == 0 ? "366" : "365" : "366" : "365"));
        return res;
    }

    public static int minIs(int a, int b, int c) {
        int res = 0;
        if (a < b && a < c) {
            res = a;
        } else if (b < c && b < a) {
            res = b;
        } else if (c < a && c < b) {
            res = c;
        }
//        res = (a < b && a < c) ? (b < c && b < a) ? a : b : c; // работает не корректно
        return res;
    }


}
