package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int[] arrIntBig = new int[20];
        int[] arrInt1 = new int[10], arrInt2 = new int[10];

        for (int i = 0; i < 20; i++) {
            arrIntBig[i] = sc.nextInt();
        }

        int tmp;
        for (int i = 0, j=0; i < 20; i++) {
            tmp = arrIntBig[i];
            if (i <10) {
                arrInt1[i]= tmp;
            } else if(i>=10){
                arrInt2[j]=tmp;
                j++;
            }
        }

        for(int i=0; i<10; i++){
            System.out.println(arrInt2[i]);
        }
    }
}
