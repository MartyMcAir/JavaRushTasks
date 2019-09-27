package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arrStr = new String[10];
        int[] arrInt = new int[10];
        String str;

        for (int i = 0; i < 10; i++) {
            str = bf.readLine();
            arrStr[i] = str;
            arrInt[i] = str.length();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arrInt[i]);
        }
    }
}
