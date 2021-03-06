package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
// Реализуй метод isPalindromePermutation(String s) который будет возвращать true, если из всех символов строки s
// можно составить палиндром. Иначе - false.
//
//Символы в анализируемой строке ограничены кодировкой ASCII.
//Регистр букв не учитывается.

// https://javarush.ru/tasks/com.javarush.task.task39.task3908#discussion
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("wqewe"));
        System.out.println(isPalindromePermutation("tot"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        Map<Character, Integer> stats = new HashMap<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (stats.containsKey(c)) {
                stats.put(c, stats.get(c) + 1);
            } else {
                stats.put(c, 1);
            }
        }

        if (s.length() % 2 == 0) {
            for (int i : stats.values()) {
                if (i % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else {
            boolean wasOddNumber = false;
            for (int i : stats.values()) {
                if (i % 2 != 0) {
                    if (wasOddNumber) {
                        return false;
                    }
                    wasOddNumber = true;
                }
            }
            return wasOddNumber;
        }
    }



    public static boolean isPalindromePermutationV2(String s) {
        if (s == null || s.isEmpty()) return false;
        char[] chars = s.toUpperCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }

        boolean wasOdd = false;
        for (Integer integer : map.values()) {
            if (chars.length % 2 == 0) {
                if (integer % 2 != 0) return false;
            } else {
                if (integer % 2 != 0) {
                    if (wasOdd) return false;
                    wasOdd = true;
                }
            }
        }
        return true;
    }
}
