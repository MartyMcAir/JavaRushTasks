package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
//        System.out.println(isDateOdd("JANUARY 1 2000"));
//        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(date));
//        return (cal.get(Calendar.DATE)%2)==0 ? false : true;
        return (cal.get(Calendar.DAY_OF_YEAR)%2)==0 ? false : true;
    }
}
