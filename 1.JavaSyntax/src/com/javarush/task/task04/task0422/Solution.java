package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name, age;
        name = bf.readLine();
        age = bf.readLine();
        if(Integer.parseInt(age)<18){
            System.out.println("Подрасти еще");
        }
    }
}
