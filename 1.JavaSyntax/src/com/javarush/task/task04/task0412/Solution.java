package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tmp = Integer.parseInt(bf.readLine()), res =0;
        if(tmp <0){
            res = tmp+1;
        } else if(tmp >0){
            res = tmp*2;
        } else if (tmp ==0){
            res= tmp;
        }
        System.out.println(res);
    }

}