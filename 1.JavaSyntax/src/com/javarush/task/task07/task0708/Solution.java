package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();

        String tmp;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<5; i++){
            tmp= bf.readLine();
            strings.add(tmp);
            if(tmp.length() >max){
                max= tmp.length(); // вычисляем максимальную длину строки
            }
        }

        for(int i=0;i<5; i++){
            tmp = strings.get(i);
            if(tmp.length()==max){
                System.out.println(tmp);
            }
        }

    }
}
