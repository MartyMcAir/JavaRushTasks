package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=0, tmp=0, i = 0;
        while(true){ //(n != -1){
            n = sc.nextInt();
            if(n==-1){
                break;
            }
            i++;
            tmp= n+tmp;
        }
//        System.out.println(tmp);
//        System.out.println(i);
        System.out.println(((double)tmp/(double)i));
    }
}

