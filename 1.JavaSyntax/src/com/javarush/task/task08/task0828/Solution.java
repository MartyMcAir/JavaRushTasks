package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
//        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("en", "US")); // работает
        Locale.setDefault(Locale.US); // не работает
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.getDefault()); // а вот так работает

//        dfs.setLocalPatternChars(Locale.ENGLISH.toString()); // не работает
//        dfs.setLocalPatternChars(new Locale("en", "US").toString()); // не работает
//        Locale.setDefault(new Locale("en", "US")); // не работает
        // [January, February, March, April, May, June, July, August, September, October, November, December, ]
//        System.out.println(Arrays.toString(dfs.getMonths()));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

//        String[] arrM = dfs.getMonths();
//        for(int i=0; i<arrM.length; i++){
//            if(arrM[i].trim().equalsIgnoreCase(str.trim())){
//                System.out.println(str+" is the "+(i+1)+" month");
//            }
//        }

//        ArrayList<String> list = new ArrayList<String>(13);
//        Collections.addAll(list, "", "January", "February", "March", "April", "May", "June",
//                "July", "August", "September", "October", "November", "December");
//        for(int i=0; i<list.size();i++){
//            if(list.get(i).equalsIgnoreCase(str.trim())){
//                System.out.println(str+" is the "+i+" month");
//            }
//        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("january", 1);
        map.put("february", 2);
        map.put("march", 3);
        map.put("april", 4);
        map.put("may", 5);
        map.put("june", 6);
        map.put("july", 7);
        map.put("august", 8);
        map.put("september", 9);
        map.put("october", 10);
        map.put("november", 11);
        map.put("december", 12);
        System.out.println(str + " is the " + map.get(str.trim().toLowerCase()) + " month");
    }
}
