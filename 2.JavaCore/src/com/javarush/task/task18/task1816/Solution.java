package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] engArr = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
//        System.out.println(engArr.length);   // 26

//        String tmp, fileName = bf.readLine();
        String tmp, fileName = args[0];
//        String fileName = "C:\\z_n\\new_test_folder\\file_name.txt";
        int count = 0;
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(fileName));

        while (bfIn.available() > 0) {
            tmp = Character.toString((char) bfIn.read()).toLowerCase();
            for (int i = 0; i < engArr.length; i++) {
                if (tmp.equals(engArr[i])) {
                    count++;
                }
            }
//            System.out.println(tmp + " " + count);
        }
        System.out.println(count);
        bfIn.close();
    }
}
