package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        //напишите тут ваш код
//        String[] arrStr1 = {"", "", ""};
//        String[] arrStr2 = {"", "", ""};
//        String[][] arrStr = {arrStr1, arrStr2};
//        ArrayList<String>[] list = Arrays.asList((ArrayList<String>[]) arrStr);
//        ArrayList<String>[] list = Arrays.asList((T[]) arrStr);

        ArrayList<String> list1 = new ArrayList<String>(Collections.nCopies(3, "A"));
        ArrayList<String> list2 = new ArrayList<String>(Collections.nCopies(3, "B"));
        ArrayList<String> list3 = new ArrayList<String>(Collections.nCopies(3, "C"));
//        ArrayList<String>[] list = new ArrayList<ArrayList<String>>(3);

//        ArrayList<String>[] list = new ArrayList[]{list2, list3}; // new ArrayList<String>()
        ArrayList<String>[] list = new ArrayList[3];
//        ArrayList<String>[] list = (ArrayList<String>[])new ArrayList[4];

        for (Integer i = 0; i < list.length; i++) {
            if (i == 0) {
                list[i] = list1;
            }
            if (i == 1) {
                list[i] = list2;
            }
            if (i == 2) {
                list[i] = list3;
            }
        }

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}