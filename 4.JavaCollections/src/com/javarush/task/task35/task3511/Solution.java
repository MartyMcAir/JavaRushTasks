package com.javarush.task.task35.task3511;

import java.util.*;

/* 
Wildcards для коллекций
*/
public class Solution {

    public static void main(String[] args) {
        List<Integer> listNumbers = new ArrayList<>();
        Collections.addAll(listNumbers, 1, 2, 3, 4, 5, 6, 7, 8);
        Double sum = sum(listNumbers);

        System.out.println(sum);
        System.out.println(multiply(listNumbers));

        List<String> listStr = new ArrayList<>();
        Collections.addAll(listStr, "is ", " new ", " line ");
        System.out.println("'" + concat(listStr) + "'");

        List<Collection> listCollect = new ArrayList<>();
        listCollect.add(new LinkedList());
        listCollect.add(new ArrayList());
        System.out.println(combine(listCollect));
    }

    public static Double sum(List<? extends Number> list) {
        Double result = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = (Number) list.get(i);
            result += numb.doubleValue();
        }
        return result;
    }

    public static Double multiply(List<? extends Number> list) {
        Double result = 1.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = (Number) list.get(i);
            result *= numb.doubleValue();
        }
        return result;
    }

    //    public static String concat(List<? extends String> list) {
    public static String concat(List<?> list) {
        StringBuilder builder = new StringBuilder();
        for (Object obj : list) {
            builder.append(obj);
        }
        return builder.toString();
    }

    public static List combine(List<? extends Collection> list) {
        List result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Collection collection = (Collection) list.get(i);
            result.addAll(collection);
        }
        return result;
    }
}
