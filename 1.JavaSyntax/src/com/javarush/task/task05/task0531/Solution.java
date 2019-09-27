package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int a = Integer.parseInt(reader.readLine());
//        int b = Integer.parseInt(reader.readLine());
//        int minimum = min(a, b);
        int[] intArr=new int[5];
        for(int i=0;i<5; i++){
            intArr[i]=Integer.parseInt(reader.readLine());
        }

        int minimum = min(intArr[0], intArr[1], intArr[2], intArr[3], intArr[4]);
        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e) {
//        return a < b ? a : b;
        int res = 0;
        int min1 = a < b ? a : b;
        int min2 = c < d ? c : d;
        res = min1 < min2 ? min1 : min2;
        return e < res ? e : res;
    }
}
