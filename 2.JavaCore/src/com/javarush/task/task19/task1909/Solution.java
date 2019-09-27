package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
//        String file1 = arrF[0];
//        String file2 = arrF[1];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        String file2 = bf.readLine();
        bf.close();

        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        String line;
        Pattern p = Pattern.compile("\\.");
        while ((line = bfR.readLine()) != null) {
            String tmp = "";
            Matcher m = p.matcher(line);
            while (m.find()) {
                tmp += m.replaceAll("!");
            }
            list.add(tmp);
        }
        bfR.close();
//        list.forEach(v-> System.out.println(v));

        BufferedWriter bfWr = new BufferedWriter(new FileWriter(file2));
        for (String item : list) {
            bfWr.write(item);
            bfWr.newLine();
        }
        bfWr.close();

    }
}
