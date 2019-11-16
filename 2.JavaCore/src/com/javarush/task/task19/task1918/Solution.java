package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];
//        String file2 = myPath()[1];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        bf.close();

        String tag = args[0];
//        String tag = "span";

        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        String tmp = "";
        while (bfR.ready()) {
            tmp += bfR.readLine();
        }
        bfR.close();

        String data = tmp;

        String startTag = "<" + tag;
        String endTag = "</" + tag + ">";
        int startTagIndex;
        int endTagIndex;
        int tempStartTagIndex = 0;
        while (tempStartTagIndex != -1) {
            // Возвращает индекс позиции, с которой начинается вхождение
            // подстроки в строку. Если подстрока в строку не входит, то возвращается значение –1.
            startTagIndex = data.indexOf(startTag, tempStartTagIndex);
            if (startTagIndex == -1) {
                return;
            }
            // по сути идет вычисление стратового и конченого тега через indexOf
            endTagIndex = data.indexOf(endTag, startTagIndex);

            // если +1 убрать то будет бессконечный цикл
            tempStartTagIndex = data.indexOf(startTag, startTagIndex + 1); // зачем +1!?
            // если tempStartTagIndex имеет номер индекса а не -1
            // и стартовый индекс меньше конечного, то конечный индекс
            if (tempStartTagIndex < endTagIndex && tempStartTagIndex != -1) {
                // если убрать здесь +1 _ ничего не изменится
                endTagIndex = data.indexOf(endTag, endTagIndex + 1); // зачем +1!?
            }
            // выводим результ и все по новой, если tempStartTagIndex содержит индекс вхождения, а не -1
            System.out.println(data.substring(startTagIndex, endTagIndex + endTag.length()));
        }
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file_2.txt", dir
                + "file3.txt"};
    }
}
