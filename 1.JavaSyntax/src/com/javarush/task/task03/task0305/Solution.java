package com.javarush.task.task03.task0305;

/* 
Я так давно родился
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(1989, 4, 19);

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyLocalizedPattern("MMM d y");
        System.out.println(sdf.format(cal.getTime()).toString().toUpperCase());
    }
}
