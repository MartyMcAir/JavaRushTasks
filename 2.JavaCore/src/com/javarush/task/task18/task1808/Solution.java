package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bf.readLine(), fileName2 = bf.readLine(), fileName3 = bf.readLine();
//        String fileName1 = "C:\\z_n\\new_test_folder\\file_name.txt";
//        String fileName2 = "C:\\z_n\\new_test_folder\\file2.txt";
//        String fileName3 = "C:\\z_n\\new_test_folder\\file3.txt";

        BufferedInputStream bfIn1 = new BufferedInputStream(new FileInputStream(fileName1));
        BufferedOutputStream bfOut2 = new BufferedOutputStream(new FileOutputStream(fileName2));
        BufferedOutputStream bfOut3 = new BufferedOutputStream(new FileOutputStream(fileName3));

        int countByte = bfIn1.available();
//        System.out.println(countByte); // показывает кол-во байт _ 45
//        System.out.println(((countByte % 2) != 0)); // 45 это не четное true

        int tmp1 = countByte / 2;
        int tmp2 = countByte - tmp1;
        int inFile2, inFile3;
        if ((countByte % 2) != 0) { // если нечетное
            inFile2 = tmp1 > tmp2 ? tmp1 : tmp2;
            inFile3 = tmp1 < tmp2 ? tmp1 : tmp2;
        } else {
            inFile2 = tmp1 < tmp2 ? tmp1 : tmp2;
            inFile3 = tmp1 > tmp2 ? tmp1 : tmp2;
        }

//        System.out.println(inFile2 + " " + inFile3); // при нечетном в F2 будет записано больше байт
        // а как с помощью mark()?


        byte[] bufferF2 = new byte[inFile2];
        byte[] bufferF3 = new byte[inFile3];
        int countF2, countF3;
        while (bfIn1.available() > 0) {
            countF2 = bfIn1.read(bufferF2);
            countF3 = bfIn1.read(bufferF3);
            bfOut2.write(bufferF2, 0, countF2);
            bfOut3.write(bufferF3, 0, countF3);
        }

        bf.close();
        bfIn1.close();
        bfOut2.close();
        bfOut3.close();
    }
}
