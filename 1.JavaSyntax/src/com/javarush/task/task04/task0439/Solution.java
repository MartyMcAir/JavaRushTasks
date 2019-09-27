package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st = bf.readLine();
        for(int i=0; i<10; i++){
            System.out.println(st+" любит меня.");
        }

    }
}
