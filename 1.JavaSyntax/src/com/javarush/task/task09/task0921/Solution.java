package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int tmp;
        while(true){
            try {
                tmp = sc.nextInt();
                list.add(tmp);
            } catch(InputMismatchException e){
                break;
            }
        }
        list.forEach((n)->System.out.println(n));
    }
}
