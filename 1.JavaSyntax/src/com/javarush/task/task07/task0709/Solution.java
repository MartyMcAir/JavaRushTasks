package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        String tmp;
        for(int i=0;i<5;i++){
            tmp=bf.readLine();
            list.add(tmp);
            if(tmp.length()<min){
                min=tmp.length();
            }
        }

        for(String s : list){
            if (s.length() == min) {
                System.out.println(s);
            }
        }
    }
}
