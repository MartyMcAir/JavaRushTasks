package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n1 = Integer.parseInt(bf.readLine());
        int n2 = Integer.parseInt(bf.readLine());

        System.out.println(str+" получает "+n1+" через "+n2+" лет.");
    }
}
