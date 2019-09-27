package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n1, n2, n3;
        n1 = Integer.parseInt(bf.readLine());
        n2 = Integer.parseInt(bf.readLine());
        n3 = Integer.parseInt(bf.readLine());

        String res = null;
        if (n1 == n2 && n1 != n3) {
            res = n1 + " " + n2;
        } else if (n1 == n3 && n1 != n2) {
            res = n1 + " " + n3;
        } else if (n2 == n3 && n2 != n1) {
            res = n2 + " " + n3;
        } else if (n1 == n2 && n1 == n3) {
            res = n1 + " " + n2 + " " + n3;
        }
        if(res!=null) {
            System.out.println(res);
        }
    }
}