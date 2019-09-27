package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x, y, res=0;
        x = sc.nextInt();
        y = sc.nextInt();
        if(x>0 && y>0){
            res=1;
        }else if(x<0 && y>0){
            res=2;
        }else if(x<0 && y<0){
            res=3;
        }else if(x>0 && y<0){
            res=4;
        }
        System.out.println(res);
    }
}
