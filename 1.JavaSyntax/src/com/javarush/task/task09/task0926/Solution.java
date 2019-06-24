package com.javarush.task.task09.task0926;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();
        Collections.addAll(list, new int[5], new int[2], new int[4], new int[7], new int[0]);
        for (int[] arr : list) {
            Arrays.fill(arr, arr.length);
        }
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
