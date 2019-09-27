package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arrStr = new String[10];
//        Arrays.fill(arrStr, "Type");
        for (int i = 0; i < 8; i++) { // i <10
//            if (i < 8) {
                arrStr[i] = bf.readLine();
//            } else {
//                arrStr[i] = "type";
//            }
        }

        for (int i = 9; i >= 0; i--) {
            System.out.println(arrStr[i]);
        }
    }
}