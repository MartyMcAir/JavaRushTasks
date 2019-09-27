package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        String tmp;
        for(; ;){
            tmp=reader.readLine();
            if(!tmp.equals("end")){
                list.add(tmp);
            } else{
                break;
            }
        }
//        Iterator it = list.iterator();
        for(String st : list){
            System.out.println(st);
        }
    }
}