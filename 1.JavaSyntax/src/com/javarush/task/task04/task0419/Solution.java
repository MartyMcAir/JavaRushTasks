package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n1, n2, n3, n4, res = 0;
        n1 = Integer.parseInt(bf.readLine());
        n2 = Integer.parseInt(bf.readLine());
        n3 = Integer.parseInt(bf.readLine());
        n4 = Integer.parseInt(bf.readLine());

        if (n1 >= n2 && n1 >= n3 && n1 >= n4) {
            res = n1;
            System.out.println(res);
        } else if (n2 >= n1 && n2 >= n3 && n1 >= n4) {
            res = n2;
            System.out.println(res);
        } else if (n3 >= n1 && n3 >= n2 && n3 >= n4) {
            res = n3;
            System.out.println(res);
        } else if (n4 >= n1 && n4 >= n2 && n4 >= n3) {
            res = n4;
            System.out.println(res);
        } else if (n1 == n2 && n1 == n3 && n1 == n4) {
            res = n3;
            System.out.println(res);
        }
        //System.out.println(res);
    }
}
