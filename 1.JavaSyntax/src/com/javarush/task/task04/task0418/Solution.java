package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n1, n2, res=0;
        n1 = Integer.parseInt(bf.readLine());
        n2 = Integer.parseInt(bf.readLine());
        if (n1 > n2) {
            res = n2;
        } else if(n2 > n1){
            res = n1;
        } else if(n2==n1){
            res=n1;
        }
        System.out.println(res);
    }
}