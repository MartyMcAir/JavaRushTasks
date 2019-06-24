package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String name = "", id = "";

        for (; ; ) {
            id = reader.readLine();
//            id = Integer.parseInt(reader.readLine());
//            if (id.equals("") || id.equals((" "))) {
            if (id.equals("") || id.equals((" "))) {
                break;
            } else {
                name = reader.readLine();
                map.put(name, Integer.parseInt(id));
            }
        }
        map.forEach((k, v) -> System.out.println(v + " " + k));

//        System.out.println("Id=" + id + " Name=" + name);
    }
}
