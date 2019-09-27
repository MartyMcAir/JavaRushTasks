package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
//        Collections.addAll(list, "альфа", "бета", "гамма");

        for (int i = 0; i < 10; i++) {
            list.add(bf.readLine());
        }

        ArrayList<String> result = doubleValues(list);
        // Вывести на экран result
        result.forEach((n) -> System.out.println(n));
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        int i = 0, k = 0, n2 = ((list.size() * 2));
        while (i < n2) { // зато максим гибкости
            if (i == k) {
                list.add(i + 1, list.get(i));
                k+=2;
            } else {
                i++;
            }
        }

//        for(int z=0; z<n2; z+=2){
//                list.add(i + 1, list.get(i));
//        }

        return list;
    }
}
