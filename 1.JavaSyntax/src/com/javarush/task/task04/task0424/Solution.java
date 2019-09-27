package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1, n2, n3, res=0;
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = sc.nextInt();

        if(n1==n2 && n1!=n3){
            res=3;
        } else if(n2==n3 && n2!=n1){
            res = 1;
        } else if(n3==n1 && n3!=n2){
            res = 2;
        }
        if(res!=0){
            System.out.println(res);
        }
    }
}
