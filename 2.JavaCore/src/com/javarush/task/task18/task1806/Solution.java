package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        FileInputStream inputStream = new FileInputStream("c:/data.txt");
//        // Создаем поток-записи-байт-в-файл
//        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

        FileInputStream inputStream = new FileInputStream("C:\\z_n\\new_test_folder\\data.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\z_n\\new_test_folder\\result.txt");

        byte[] buffer = new byte[inputStream.available()]; // code _ перенес из цикла
        int count;
        if (inputStream.available() > 0) { // code _ >= _ read заменил на available
            //читаем весь файл одним куском
            count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }


// reset используется при использ mark ярлыков при чтении
//        мол остановился туту вернутся в место где был последний раз
//        inputStream.reset(); // commented
//        outputStream.flush(); // commented _ сам срабатывает при закрытии потока

        // code
        inputStream.close();
        outputStream.close();
    }
}
