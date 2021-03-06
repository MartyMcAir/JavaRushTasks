package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = bf.readLine(), filePath2 = bf.readLine();
//        String filePath1 = "C:\\z_n\\new_test_folder\\data.txt";
//        String filePath2 = "C:\\z_n\\new_test_folder\\result.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath1));
        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(filePath2));

        // Ошибка в файле com/javarush/task/task18/task1809/Solution.java в строке : 19
        // Не найден метод "readAllBytes()" в переменной "bfIn"
//        byte[] arrByte = bfIn.readAllBytes();   // WTF!?
//
////        System.out.println(Arrays.toString(arrByte));
//        byte current;   // reverse array
//        for (int i = 0, j = arrByte.length - 1; i < j; i++, j--) {
//            current = arrByte[i]; // сохран текущее значение
//            arrByte[i] = arrByte[j]; // текущему индексу значение последнего элемента
//            arrByte[j] = current; // текущ значение присваиваем к последнему индексу
//        }
//        System.out.println(Arrays.toString(arrByte));

//        for (int i = 0; i < arrByte.length; i++) {
//            bfOut.write(arrByte[i]);
//        }

        // скопипастил с коммента
        byte[] buffer = new byte[bfIn.available()];
        bfIn.read(buffer);

        for (int i = 0; i < buffer.length / 2; i++) {
            byte temp = buffer[i];
            buffer[i] = buffer[buffer.length - 1 - i];
            buffer[buffer.length - 1 - i] = temp;
        }

        bfOut.write(buffer);

        bf.close();
        bfIn.close();
        bfOut.close();
    }
}
