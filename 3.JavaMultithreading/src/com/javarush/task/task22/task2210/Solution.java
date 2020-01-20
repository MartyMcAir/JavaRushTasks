package com.javarush.task.task22.task2210;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
        // а StringTokenizer - справился
        String[] strArr1 = "fff uuu ddd ggg".split(" ");
        System.out.println(Arrays.toString(strArr1)); // [fff, uuu, ddd, ggg]
        String[] strArr2 = "fff.uuu.ddd.ggg".split(".");
        System.out.println(Arrays.toString(strArr2)); // [] - split не разделил
    }

    public static String[] getTokens(String query, String delimiter) {
        String[] res = null;
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            list.add(tokenizer.nextToken());
//            sb.append(tokenizer.nextToken() + " "); // не принял
        }
//        return sb.toString().split(" ");
        return list.toArray(new String[list.size()]); // список в массив
    }
}
