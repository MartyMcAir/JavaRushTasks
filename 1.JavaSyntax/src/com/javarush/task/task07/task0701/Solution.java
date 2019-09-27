package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        Scanner sc = new Scanner(System.in);
        int[] arrInt = new int[20];
        for(int i=0; i<20;i++){
            arrInt[i]=sc.nextInt();
        }
        return arrInt;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int tmp, max = Integer.MIN_VALUE;
        for(int i=0; i<20;i++){
            tmp = array[i];
            if(tmp>max){
                max=tmp;
            }
        }
        return max;
    }
}
