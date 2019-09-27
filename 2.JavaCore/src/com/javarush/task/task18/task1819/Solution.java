package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine(), file2=bf.readLine();
//        String pathDir = "C:\\z_n\\new_test_folder\\";
//        String file1 = pathDir + "data1.txt", file2 = pathDir + "data2.txt", file3 = pathDir + "result.txt";


        BufferedInputStream bfIn1 = new BufferedInputStream(new FileInputStream(file1));
        BufferedInputStream bfIn2 = new BufferedInputStream(new FileInputStream(file2));

        // work _ общий массив байтов для двух файлов
        byte[] buffer = new byte[bfIn1.available() + bfIn2.available()];
        // запись начинается с индекса bfIn2.*, в кол-ве байт bfIn1.*
        bfIn1.read(buffer, bfIn2.available(), bfIn1.available()); // файл1 в конец массива
        bfIn2.read(buffer, 0, bfIn2.available()); // записываем в 0 начало массива файл2

//        BufferedOutputStream bfOut2 = new BufferedOutputStream(new FileOutputStream(file3));
        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(file1));
        bfOut.write(buffer);

        // work
//        byte[] buffer1 = new byte[bfIn1.available()];
//        byte[] buffer2 = new byte[bfIn2.available()];
//        bfIn1.read(buffer1);
//        bfIn2.read(buffer2);
//        bfOut2.write(buffer2);
//        bfOut2.write(buffer1);


        bf.close();
        bfIn1.close();
        bfIn2.close();
        bfOut.close();
//        bfOut2.close();
    }
}
