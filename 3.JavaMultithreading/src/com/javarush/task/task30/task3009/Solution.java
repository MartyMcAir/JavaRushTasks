package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/
// https://javarush.ru/tasks/com.javarush.task.task30.task3009#discussion
// опять ниче не понятно сам бы не решил
// from https://github.com/Sukora-Stas/JavaRushTasks/blob/eb0371e1b363955ec113671816fb36a5ce1f73a0/3.JavaMultithreading/src/com/javarush/task/task30/task3009/Solution.java
public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        try {
            int tempNum = Integer.parseInt(number);
            for (int i = 2; i < 37; i++) {
                String num = Integer.toString(tempNum, i);
                StringBuilder builder = new StringBuilder();
                String left;
                String right;
                if (num.length() % 2 == 0) {
                    left = num.substring(0, num.length() / 2);
                    right = builder.append(num.substring(num.length() / 2)).reverse().toString();
                    if (left.equals(right)) {
                        set.add(i);
                    }
                } else {
                    left = num.substring(0, num.length() / 2);
                    right = builder.append(num.substring(num.length() / 2 + 1)).reverse().toString();
                    if (left.equals(right)) {
                        set.add(i);
                    }
                }
            }
        } catch (NumberFormatException e) {
        }

        return set;
    }
}