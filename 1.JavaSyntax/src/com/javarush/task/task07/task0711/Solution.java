package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add(bf.readLine());
        }
//        System.out.println(list.toString()); // [1, 2, 3, 4, 5]

        for (int i = 0; i < 13; i++) {
            String lastStr = list.get((list.size() - 1));
            list.remove(4);
            list.add(0, lastStr);
        }
//        System.out.println(list.toString()); // [3, 4, 5, 1, 2]

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
