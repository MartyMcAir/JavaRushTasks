package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String res = "";
        try (BufferedReader bf = new BufferedReader(reader)) {
            int n;
            StringBuffer sbf = new StringBuffer();
            while ((n = bf.read()) != -1) {
                sbf.append((char) (n + key));
            }
            res = sbf.toString();
        } catch (Exception e) {
            return "";
        }
        return res;
    }
}
