package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] strArr = {"", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tmp = Integer.parseInt(bf.readLine());
        String res="";
        if(tmp>0 && tmp<8){
            res= ""+strArr[tmp];
        } else {
            res="такого дня недели не существует";
        }
        System.out.println(res);
    }
}