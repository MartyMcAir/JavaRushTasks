package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
//        String fileName = "C:\\z_n\\new_test_folder\\file_name.txt";

        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(fileName));
        int tmp = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        while (bfIn.available() > 0) {
            tmp = bfIn.read();
            if (tmp > max) {
                max = tmp;
            }
        }
        bf.close();
        bfIn.close();
        System.out.println(max);

    }
}
