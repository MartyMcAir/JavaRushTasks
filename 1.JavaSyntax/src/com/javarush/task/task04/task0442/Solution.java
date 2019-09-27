package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (; ; ) {
            int n = sc.nextInt();
            total = total +n; // += n
            if (n == -1) {
                //total = total-1;
                break;
            }
//            total = total +n; // += n
        }
        System.out.println(total);
    }
}
