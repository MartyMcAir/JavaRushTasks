package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        String number = args[1];
        String text = args[2];
//        String fileName = "c:\\z_n\\new_test_folder\\ttt\\data1.txt";
//        String number = "100";
//        String text = "Jurassic Park";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(Long.parseLong(number));

            // Считать текст с файла начин с позиции number, длинны такой же как и длинна переданного текста в 3 параметре.
            byte[] buffer = new byte[text.length()];

            raf.read(buffer, 0, text.length()); // 1парам начиная с индекса.. второй парам кол-во байт

            String stringIs = new String(buffer);
            raf.seek(raf.length()); // отступ чтобы запись шла в конец файла.. т.е. сдвиг на длину всего файла..

            // Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
            if (text.equals(stringIs))
                raf.write("true".getBytes());
            else
                raf.write("false".getBytes());
        }

    }
}
