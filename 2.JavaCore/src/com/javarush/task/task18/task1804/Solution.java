package com.javarush.task.task18.task1804;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bf.readLine();
//        String filePath = "C:\\z_n\\new_test_folder\\file_name.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath));
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (bfIn.available() > 0) {
            map.merge(bfIn.read(), 1, Integer::sum);
        }
        bf.close();
        bfIn.close();
//        map.forEach((k, v) -> System.out.println(k + " " + v));

        int minRepeat = Collections.min(map.values());
        for (int item : map.keySet()) {
            if (map.get(item) == minRepeat) {
                System.out.print(item + " ");
            }
        }
    }
}
