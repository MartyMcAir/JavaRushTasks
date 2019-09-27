package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String Direct = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrPath = new String[]{Direct + "some3.txt.part3", Direct + "some1.txt.part1",
                Direct + "some2.txt.part2", "end"};

        // ___ наполняем список путями к файлам, и массивами байтов
        TreeMap<String, byte[]> map = new TreeMap<>();
        String tmp, finalFile = null;

        BufferedReader bfR = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream bfIn = null;   // C:\z_n\new_test_folder\1\some1.txt.part1
//        while (!(tmp = bfR.readLine()).equals("end")) {
        for (int i = 0; i < arrPath.length & !arrPath[i].equals("end"); i++) {
            tmp = arrPath[i];
            if (finalFile == null) {
                finalFile = tmp.split(".part")[0];
            }
            bfIn = new BufferedInputStream(new FileInputStream(tmp));
            byte[] buffer = new byte[bfIn.available()];   // сохраняем путь и массив байтов файла
            bfIn.read(buffer);
            map.put(tmp, buffer);
            bfIn.close();
        }
        bfR.close();

        // обрабатываем путь, создаем имя файла и записываем в него весь буфер
        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(finalFile));
        for (byte[] item : map.values()) {
            bfOut.write(item);
        }
        bfOut.close();
    }
}
