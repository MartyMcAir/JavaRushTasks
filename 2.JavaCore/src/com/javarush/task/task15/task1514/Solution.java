package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(33.1, "a");
        labels.put(33.2, "b");
        labels.put(33.3, "c");
        labels.put(33.4, "e");
        labels.put(33.5, "f");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
