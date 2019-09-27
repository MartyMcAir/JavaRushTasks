package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];
//        String file2 = myPath()[1];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        bf.close();
//        BufferedReader bfR = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        while (bfR.ready()) {
            StringBuilder sb = new StringBuilder();
            sb.append(bfR.readLine());
            sb.reverse();
            System.out.println(sb);
        }
        bfR.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }
}
