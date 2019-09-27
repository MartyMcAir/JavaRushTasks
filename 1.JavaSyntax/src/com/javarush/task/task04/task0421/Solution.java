package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st1, st2, res;
        st1= bf.readLine();
        st2 = bf.readLine(); // trim() - удаляем пробелы и др знаки в начале и в конце
        if(st1.trim().equalsIgnoreCase(st2.trim())){ // equalsIgnoreCase() - сравниваем строки игнорируя их регистр
            System.out.println("Имена идентичны");
        } else if(st1.trim().length() == st2.trim().length()){
            System.out.print("Длины имен равны");
        }
    }
}
