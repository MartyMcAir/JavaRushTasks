package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
//        String file1 = arrF[0];
//        String file2 = arrF[1];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        while (bfR.ready()) {
            list.add(bfR.read());
        }
        bfR.close();

        BufferedWriter bfWr = new BufferedWriter(new FileWriter(file2));
        for (int i = 0; i < list.size(); i++) {
            if ((i % 2) != 0) {
                if (list.get(i) == 13 | list.get(i) == 10) {
                    bfWr.write(System.lineSeparator());
                } else {
                    bfWr.write(list.get(i));
                }
            }
        }
        bfWr.close();

    }
}
