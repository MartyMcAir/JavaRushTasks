package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];
//        String file2 = myPath()[1];
        String file1 = args[0];
        String file2 = args[1];
        ArrayList<String> list = new ArrayList<>();

//        BufferedReader bfR = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        while (bfR.ready()) {
            String tmp = "";
            String[] arrStr = bfR.readLine().split("\\s+"); // "\\s+" ",| "
//            System.out.println(Arrays.toString(arrStr));
            for (int i = 0; i < arrStr.length; i++) {
//                if (arrStr[i].matches("[а-я]+") | arrStr[i].length() > 6) { // не работает !?
//                if (arrStr[i].length() > 6) {
                if (arrStr[i].matches("\\S{7,}")) {
                    tmp += arrStr[i] + " ";
                }
            }
            if (!tmp.equals("")) {
                list.add(tmp);
            }
        }
        bfR.close();

//        list.forEach(v -> System.out.print(v));

        BufferedWriter bfWr = new BufferedWriter(new FileWriter(file2));
        for (int i = 0; i < list.size(); i++) {
            String[] arrSt = list.get(i).split(" "); // Разбиваем строку
            for (int j = 0; j < arrSt.length; j++) { // перебираем элементы массива
                if (i == (list.size() - 1) & j == (arrSt.length - 1)) {
//                    System.out.println(arrSt[j]); // последенее слово последней строки
                    bfWr.write(arrSt[j]); // последенее слово последней строки
                } else {
//                    System.out.print(arrSt[j] + ",");
                    bfWr.write(arrSt[j] + ",");
                }
            }
//            System.out.println();
//            if (i != (list.size() - 1)) { // чтоб если последняя строка запись не начинал с новой строки
//                bfWr.newLine();
//            }
        }
        bfWr.close();

    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }
}
