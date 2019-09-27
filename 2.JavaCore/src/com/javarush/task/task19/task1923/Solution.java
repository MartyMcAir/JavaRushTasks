package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];
//        String file2 = myPath()[1];
        String file1 = args[0];
        String file2 = args[1];

        BufferedReader bf = new BufferedReader(new FileReader(file1));
//        BufferedReader bf = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedWriter bfR = new BufferedWriter(new FileWriter(file2));

        String line, tmp;
        while ((line = bf.readLine()) != null) {
            String[] arrStr = line.split("\\s+");
            for (String item : arrStr) {
                if (item.matches(".*[0-9]+.*")) {
                    bfR.write(item + " ");
                }
            }
        }
        bfR.close();
        bf.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir + "file_1.txt", dir + "file2.txt", dir + "file3.txt"};
    }
}
