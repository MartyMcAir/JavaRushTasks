package com.javarush.task.task18.task1805;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bf.readLine();
//        String filePath = "C:\\z_n\\new_test_folder\\file_name.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath));

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (bfIn.available() > 0) {
            map.put(bfIn.read(), 0);
        }
        bf.close();
        bfIn.close();

        ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
//        list.forEach(v -> System.out.print(v + " "));
//        System.out.println();

        Collections.sort(list);
        list.forEach(v -> System.out.print(v + " "));
    }
}
