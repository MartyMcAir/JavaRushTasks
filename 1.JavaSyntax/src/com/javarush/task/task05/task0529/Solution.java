package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n1, res = 0;
        String tmp;
        while (true) {
            tmp = bf.readLine().trim();

            if ("сумма".equalsIgnoreCase(tmp)) {
                break;
            } else {
                n1 = Integer.parseInt(tmp);
                res = res + n1;
            }
        }
        System.out.println(res);
    }
}
