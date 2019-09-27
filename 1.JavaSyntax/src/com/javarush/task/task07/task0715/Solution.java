package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "мама", "мыла", "раму"); // 0 1 2
        list.add(1, "именно"); // 0 _1_ 2 3
        list.add(3, "именно"); // 0 1 2 _3_ 4
        list.add(5, "именно"); // 0 1 2 3 4 _5_
        list.forEach((n) -> System.out.println(n));
    }
}
