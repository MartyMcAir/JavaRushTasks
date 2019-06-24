package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath= bf.readLine();
//        String st = "C:\\z_n\\new_test_folder\\file_name.txt";

        ArrayList<Integer> listEven = new ArrayList<Integer>();
        try(BufferedReader bf2 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))){
            String line;
            int tmp;
            while((line=bf2.readLine())!=null){
                tmp =Integer.parseInt(line.trim());
                if((Math.abs(tmp)%2)==0){
                    listEven.add(tmp);
                }
            }
        }
        Collections.sort(listEven);
        listEven.forEach((v)->System.out.println(v));
    }

    // возвращает абсолютную величину числа т.е. независимую от знака - или +
    public static int abs(int a){ // (Math.abs(tmp)
        if(a<0){
            a=-a;
        } else{
            a=a;
        }
        return a;
    }
}




