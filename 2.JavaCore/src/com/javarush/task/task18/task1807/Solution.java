package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bf.readLine();
//        String filePath = "C:\\z_n\\new_test_folder\\file_name.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath));

        // нужно сравнивать с ascii-кодом символа ','.
        // http://www.asciitable.com/ _ = code is 44
        int count = 0;
        while (bfIn.available() > 0) {
            if (bfIn.read() == 44) {
                count++;
            }
        }
        bf.close();
        bfIn.close();
        System.out.println(count);
    }
}
