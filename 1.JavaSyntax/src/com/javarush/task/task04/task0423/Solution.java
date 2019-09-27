package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st1, st2;
        st1 = bf.readLine();
        st2 = bf.readLine();
        if(Integer.parseInt(st2)>20){
            System.out.println("И 18-ти достаточно");
        }
    }
}
