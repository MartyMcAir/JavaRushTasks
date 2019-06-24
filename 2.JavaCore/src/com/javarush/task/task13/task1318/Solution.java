package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        // 3. Поток чтения из файла (FileInputStream) должен быть закрыт.
        // 4. BufferedReader также должен быть закрыт.

        BufferedReader bfR = null;
        InputStream in = null;
        try {
            bfR = new BufferedReader(new InputStreamReader(System.in));
//        String name = bfR.readLine();
            String name = "file_name";

            //  InputStream inStream = new FileInputStream("c:/source.txt"); from Java Rush
//            in = new FileInputStream("C:\\z_n\\new_test_folder\\" + name + ".txt");
            in = new FileInputStream(name);

//            FileReader file = new FileReader("C:\\z_n\\new_test_folder\\file_name.txt");
            Path p = Paths.get("C:\\z_n\\new_test_folder\\" + name + ".txt");
            BufferedReader buffer = Files.newBufferedReader(p, Charset.forName("cp1251"));

//            BufferedReader buffer = new BufferedReader(file);
            String line = "";
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
            }


//            while (in.available() > 0) {
//                System.out.print((char) in.read()); // если println то пишет слишкоммного строк
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close(); // закрыие происходит в обратном порядке открытию
            bfR.close();
        }
    }
}