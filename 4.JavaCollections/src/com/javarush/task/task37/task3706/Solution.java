package com.javarush.task.task37.task3706;

import java.util.Arrays;
import java.util.List;

/* 
Давно забытый Array
*/
public class Solution {
    public static void main(String[] args) {
        List<Number> numbers = Arrays.<Number>asList(1, 2, 3);
        // метод asList возвращает неизменяемый список и вставка в него невозможна.
        addDataToList(numbers, getData());
        System.out.println(numbers);
    }

    public static Number[] getData() {
//        Number[] arrNum = {1, 2, 3, 4, 5, 6}; // Exception
        Number[] arrNum2 = {};  // no Exception
        return arrNum2;
    }

    public static void addDataToList(List<Number> list, Number... data) {
        for (Number number : data)
            list.add(number);
    }
}
