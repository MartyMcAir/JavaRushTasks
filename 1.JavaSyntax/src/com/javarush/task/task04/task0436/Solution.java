package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ln = sc.nextInt();
        int wide = sc.nextInt();

        for(int i=0; i<ln; i++){
            for(int j=0; j<wide; j++){
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
