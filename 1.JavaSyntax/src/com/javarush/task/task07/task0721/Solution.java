package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        //напишите тут ваш код
        int[] intArr = new int[20];
        int tmp;
        for(int i=0; i<intArr.length; i++){
            tmp=Integer.parseInt(reader.readLine());
            if(tmp<minimum){
                minimum=tmp;
            }
            if(tmp>maximum){
                maximum=tmp;
            }
            intArr[i]=tmp;
        }

        System.out.print(maximum + " " + minimum);
    }
}
