package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
//        String file1 = arrF[0];
//        String file2 = arrF[1];

        String file1 = args[0];

        TreeMap<String, Double> map = new TreeMap<>();

//        BufferedReader bf = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedReader bf = new BufferedReader(new FileReader(file1));
        while (bf.ready()) {
            String[] strArr = bf.readLine().split(" ");
//            System.out.println(strArr[0] + " " + strArr[1]);
            map.merge(strArr[0], Double.parseDouble(strArr[1]), (oldV, newV) -> (oldV + newV));
        }
        bf.close();

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
