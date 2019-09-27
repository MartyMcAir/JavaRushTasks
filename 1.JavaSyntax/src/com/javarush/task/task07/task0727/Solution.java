package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> lisNew = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s == null || s.isEmpty()) {
                break;
            }
            if ((s.length() % 2) == 0) {
                lisNew.add(s+" "+s);
//                lisNew.add(s);
            }
            if ((s.length() % 2) != 0) {
                lisNew.add(s+" "+s+" "+s);
            }
            list.add(s);
        }

        ArrayList<String> listUpperCase = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            listUpperCase.add(s.toUpperCase());
        }

        for (int i = 0; i < lisNew.size(); i++) {
            System.out.println(lisNew.get(i));
        }
    }
}
