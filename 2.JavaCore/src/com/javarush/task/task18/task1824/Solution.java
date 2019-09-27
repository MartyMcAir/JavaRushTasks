package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = null;

//        String DirectoryPath = "C:\\z_n\\new_test_folder\\";
//        String[] arrFile = new String[]{DirectoryPath + "data1.txt", DirectoryPath + "data2.txt", "exit"};

//        System.out.println(Files.exists(Paths.get(arrFile[2])));
//        String fline = arrFile[2];
        FileInputStream fs = null;
        while (true) {
            try {
                tmp = bf.readLine();
                fs = new FileInputStream(tmp);
//                Files.exists(Paths.get(fs.toString()));
                fs.close();
            } catch (FileNotFoundException e) {
                System.out.println(tmp);
                break;
//            e.printStackTrace();
            }
//            fs.close();
        }

        bf.close();
    }
}
