package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().trim(); // trim() - убираем пробелы и т.д.
        String[] sArr = {"", "однозначное", "двузначное", "трехзначное"};
        int n = Integer.parseInt(str); // текст в фифру

        if (n >= 1 && n <= 999) {
            String negApos = (n%2)==0 ? "четное" : "нечетное";
            System.out.println(negApos+" "+sArr[str.length()]+" число");
        }
    }
}
