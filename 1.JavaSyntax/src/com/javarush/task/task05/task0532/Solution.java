package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        int n1 = Integer.parseInt(reader.readLine());
        if (n1 > 0) {
            int maximum = Integer.MIN_VALUE, tmp;
            for (int i = 0; i < n1; i++) {
                tmp = Integer.parseInt(reader.readLine());
                if (tmp > maximum) {
                    maximum = tmp;
                }
            }
            System.out.println(maximum);
        }
    }
}
