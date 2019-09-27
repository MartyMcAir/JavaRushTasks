package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import java.nio.charset.Charset;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String str = String.valueOf(number);
        char[] chArr = str.toCharArray();
        int res=0, tmp;
        for(int i=0;i<chArr.length;i++){
            tmp = Integer.parseInt(String.valueOf(chArr[i]));
            res +=tmp;
        }
        return res;
    }
}