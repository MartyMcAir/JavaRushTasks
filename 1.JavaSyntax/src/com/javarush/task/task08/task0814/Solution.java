package com.javarush.task.task08.task0814;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        // напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        Collections.addAll(set, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> it = set.iterator();
        int tmp;
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp > 10) {
                it.remove();
            }
        }
        return set;
    }

    public static void main(String[] args) {
//        HashSet<Integer> set = removeAllNumbersGreaterThan10(createSet());
//        System.out.println(set);
    }
}
