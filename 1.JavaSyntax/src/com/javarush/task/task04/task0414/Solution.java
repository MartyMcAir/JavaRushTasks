package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tmp = Integer.parseInt(bf.readLine());
        String res = "";
        if ((tmp % 400 == 0 || tmp % 100 != 0) && (tmp % 4 == 0)) { // высокосный год
            res = "количество дней в году: 366";
        } else {
            res = "количество дней в году: 365";
        }
        System.out.println(res);

        // wikihow
/*        if((tmp%4)==0){ // высокосный год

        } else if((tmp%4)!=0){ // не высокосный год

        } else if((tmp%4)==0 && (tmp%100)!=0){ // высокосный год

        } else if((tmp%4)==0 && (tmp%100)==0){ // возможно не высокосный год
            if((tmp%400==0)){ // высокосный год

            } else if(tmp%400!=0){ // не высокосный год

            }
        } else if((tmp%100)==0 && (tmp%400)!=0){ // не высокосный год

        }*/
    }
}