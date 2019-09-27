package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int posCount = 0, negCount = 0;
        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            if (n > 0) {
                posCount++;
            } else if (n < 0) {
                negCount++;
            }
        }
        System.out.println("количество отрицательных чисел: " + negCount);
        System.out.println("количество положительных чисел: " + posCount);
    }
}
