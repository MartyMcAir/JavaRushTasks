package com.javarush.task.task36.task3603;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* 
Поиск класса по описанию
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3603#discussion // copy past
// Замени следующие слова на нужные:
//1. ClassNameToBeReplaced - имя класса, потокобезопасный аналог ArrayList, в котором все операции изменения
// (mutative operations) используют новую копию основного массива.
//2. methodNameToBeReplaced - имя метода, который в текущий список 'list' добавляет те элементы переданной коллекции,
// которые не содержатся в 'list'.
public class Solution_2 {
    public static void main(String... args) {    //it's correct line
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        List<String> collection = Arrays.asList(new String[]{"B", "C", "D", "B"});

        // Appends all of the elements in the specified collection that are not already contained in this list,
        // to the end of this list,
        list.addAllAbsent(collection); // добавится D

        for (String string : list) {
            System.out.println(string);
        }
        /* Expected output
A
C
B
D
         */
    }

    public static void mainOrigin(String... args) {    //it's correct line
//        ClassNameToBeReplaced<String> list = new ClassNameToBeReplaced();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.remove("B");
//        List<String> collection = Arrays.asList(new String[]{"B", "C", "D", "B"});
//
//        list.methodNameToBeReplaced(collection);
//
//        for (String string : list) {
//            System.out.println(string);
//        }
    }
}