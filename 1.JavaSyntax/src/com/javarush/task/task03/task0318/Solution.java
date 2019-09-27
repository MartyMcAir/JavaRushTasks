package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("число: ");
        int n = Integer.parseInt(bfr.readLine());
        // System.out.println("имя: ");
        String str = bfr.readLine();
        System.out.println(str+" захватит мир через "+n+" лет. Му-ха-ха!");
    }
}
