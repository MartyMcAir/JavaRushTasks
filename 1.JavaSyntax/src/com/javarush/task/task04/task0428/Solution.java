package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int j = 0;
        for (int i = 0; i < 3; i++) {
            if (sc.nextInt() > 0) {
                j++;
            }
        }
            System.out.println(j);

    }
}
