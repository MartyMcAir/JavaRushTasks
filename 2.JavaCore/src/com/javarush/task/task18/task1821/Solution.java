package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
//        String pathDir = "C:\\z_n\\new_test_folder\\";
//        String file1 = pathDir + "data1.txt", file2 = pathDir + "data2.txt", file3 = pathDir + "result.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(file1));

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int tmp;
        while (bfIn.available() > 0) {
            tmp = bfIn.read();
            // если не полбел и не новая строка
//            if (!Character.isWhitespace(tmp) && !Character.isSpaceChar(tmp)) {
//            }
                map.merge((tmp), 1, Integer::sum);
        }
//        map.forEach((k, v) -> System.out.println("[" + (char) Integer.parseInt(k.toString()) + "] " + v));
        ArrayList<Integer> listKey = new ArrayList<Integer>(map.keySet());
//        listKey.forEach(v -> System.out.print(v + " "));
        Collections.sort(listKey);
//        System.out.println();
//        listKey.forEach(v -> System.out.print(v + " "));
//        System.out.println();

        // Отсортировать результат по возрастанию кода ASCII (почитать в инете).
        // т.е. по коду полученного байта, 32 это пробел
        for (Integer item : listKey) {
//            System.out.println("[" + (char) Integer.parseInt(item.toString()) + "] " + map.get(item));
            System.out.println((char) Integer.parseInt(item.toString()) + " " + map.get(item));
        }

        bfIn.close();
    }
}
