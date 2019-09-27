package com.javarush.task.task19.task1924;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        bf.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        while (fileReader.ready()) {
            String line[] = fileReader.readLine().split("\\s+");
            for (int i = 0; i < line.length; i++) {
                try {
                    if (map.containsKey(Integer.parseInt(line[i]))) {
                        line[i] = map.get(Integer.parseInt(line[i]));
                    }
                } catch (NumberFormatException e) {
                }
            }
            // выводим результ из (разсплиттиного) массива строк
            for (String s : line) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        fileReader.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }
}
