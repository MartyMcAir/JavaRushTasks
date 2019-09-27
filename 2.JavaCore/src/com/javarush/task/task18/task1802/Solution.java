package com.javarush.task.task18.task1802;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bfr.readLine();
//        String filePath = "C:\\z_n\\new_test_folder\\file_name.txt";

        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath));
        int tmp = 0, min = Integer.MAX_VALUE;
        while (bfIn.available() > 0) {
            tmp = bfIn.read();
            if (min > tmp) {
                min = tmp;
            }
        }
        bfIn.close();
        System.out.println(min);
    }
}
