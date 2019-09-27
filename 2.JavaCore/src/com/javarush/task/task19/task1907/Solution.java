package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Интересно, если файл будет 10Гб... Тогда варианты с впихиванием всего файла в строку не годятся..
        // Надо искать частями или до первого знака препинания.
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file.txt", dir + "file2.txt", dir + "file3.txt"};
//        String file = arrF[0]; // 8 world
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader bfR = new BufferedReader(new FileReader(file));
        String tmp;
        while ((tmp = bfR.readLine()) != null) {
            if (tmp.contains("world")) {
                list.add(tmp);   // наполняем список, строками содержащими слово world
            }
        }
        bfR.close();

        String[] arrStr;
        int counter = 0;
        for (String item : list) {
            // сохраняем в массив, разделенные слова знаками и пробелами
            // Проверь, почему программа находит больше слов "world" чем есть в файле.
            // - вылечилось поменя в split()
            arrStr = item.split("^\\w");
            for (int i = 0; i < arrStr.length; i++) {
                if (arrStr[i].contains("world")) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
