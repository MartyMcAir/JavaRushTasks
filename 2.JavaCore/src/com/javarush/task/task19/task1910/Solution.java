package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;

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

        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        ArrayList<String> list = new ArrayList<String>();
        String line, tmp = "";
        while ((line = bfR.readLine()) != null) {
//            tmp += line.replaceAll("\\.|\\,|\\.|\\:|\\;|\\n|\\_", "");
//            tmp += line.replaceAll("[^\\d|\\w|\\s]+", "");
//            tmp += line.replaceAll("[\\p{Punct}\\p{Space}]", "");
//            tmp += line.replaceAll("[\\s!@#$%^&*(),./]", "");
            tmp += line.replaceAll("\\pP", "");
        }
        list.add(tmp);
        bfR.close();

        BufferedWriter bfWr = new BufferedWriter(new FileWriter(file2));
        for (String item : list) {
            bfWr.write(item);
            bfWr.newLine();
        }
        bfWr.close();

    }
}
