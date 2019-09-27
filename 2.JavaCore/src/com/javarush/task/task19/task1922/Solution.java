package com.javarush.task.task19.task1922;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        bf.close();

        BufferedReader bfR = new BufferedReader(new FileReader(file1));
//        BufferedReader bfR = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        String line;
        int countLine = 0;
        while ((line = bfR.readLine()) != null) {
            if (isMatch(line)) {   // если количество слов совпавших всего два
                System.out.println(line);
            }
        }
        bfR.close();
    }

    private static boolean isMatch(String row) {
        String[] rowWords = row.split("\\s+");
        long count = Arrays.stream(rowWords)
                .filter(word -> words.contains(word))
                .count();
        return count == 2;
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
    }
}
