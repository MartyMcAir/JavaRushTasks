package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st = bf.readLine();
//        String st = "2013-08-18";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
        Date d1 = sdf.parse(st);
//        System.out.println(d1); // Sun Aug 18 00:00:00 MSK 2013

        Date d2 = new Date(d1.getTime());
        sdf.applyPattern("MMM d, yyyy");

        System.out.println(sdf.format(d2).toString().toUpperCase()); // AUG 18, 2013
    }
}
