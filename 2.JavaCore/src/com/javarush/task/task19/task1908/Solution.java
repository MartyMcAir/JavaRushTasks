package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
        String file1 = arrF[0];
        String file2 = arrF[1];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
        reader.close();

        ArrayList<String> list = new ArrayList<>();
        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        String line, tmp = "";
        Pattern p = Pattern.compile("\\b(-?\\d+)\\b", Pattern.UNICODE_CHARACTER_CLASS);
        while ((line = bfR.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                tmp += m.group() + " ";
            }
            list.add(tmp);
        }
        bfR.close();

        BufferedWriter bfWr = new BufferedWriter(new FileWriter(file2));
        for (String item : list) {
            bfWr.write(item);
            bfWr.newLine();
        }
        bfWr.close();

    }
}
