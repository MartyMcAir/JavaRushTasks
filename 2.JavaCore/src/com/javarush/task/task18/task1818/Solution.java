package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine(), file2 = bf.readLine(), file3 = bf.readLine();
//        String pathDir = "C:\\z_n\\new_test_folder\\";
//        String file1 = pathDir + "result.txt", file2 = pathDir + "data1.txt", file3 = pathDir + "data2.txt";

        // true - т.е. не перезаписывать а дописать в файл
        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(file1, true));

        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedInputStream bfIn1 = new BufferedInputStream(new FileInputStream(file2));
//        bfOut.write(bfIn1.readAllBytes()); // work _ but пишет типо тут ошибка _ хотя код рабочий

//        Если первый файл не пуст то флаг true решит дозаписать в конец. решил сделать так:
//        int sizeF2 = file2.available();
//        int sizeF3 = file3.available();
//
//        byte [] bytes = new byte[ sizeF2 + sizeF3 ];
//        file2.read(bytes, 0, sizeF2);
//        file3.read(bytes, sizeF2, sizeF3);
//        file1.write(bytes);

        while (bfIn1.available() > 0) {
//            list.add(bfIn1.read());
            bfOut.write(bfIn1.read());   // work
        }
        bfIn1.close();

        BufferedInputStream bfIn2 = new BufferedInputStream(new FileInputStream(file3));
        while (bfIn2.available() > 0) {
//            list.add(bfIn2.read());
            bfOut.write(bfIn2.read());   // work
        }
        bfIn2.close();

        // work
//        for (int item : list) {
//            bfOut.write(item);
//        }
        bfOut.close();
    }
}
