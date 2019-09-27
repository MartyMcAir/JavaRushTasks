package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int paramID = Integer.parseInt(args[0]);
//        int paramID = 3;
//        String paramIDStr = "3";
        String paramID = args[0];
        String file1 = bf.readLine();
//        String pathDir = "C:\\z_n\\new_test_folder\\";
//        String file1 = pathDir + "data1.txt", file2 = pathDir + "data2.txt", file3 = pathDir + "result.txt";

        BufferedReader bfIn = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
        String line;
        while ((line = bfIn.readLine()) != null) {
            if (line.trim().startsWith(paramID+" ")) {
                System.out.println(line);
            }
        }
        bf.close();
        bfIn.close();
    }
}
