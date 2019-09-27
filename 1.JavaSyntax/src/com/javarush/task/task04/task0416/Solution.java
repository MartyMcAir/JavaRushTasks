package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        double tmp = Double.parseDouble(input);

        // green 3 m _ yellow 1m _ red 1m - and repeat again
        String res = "";
        if ((tmp % 5) >= 0 && (tmp % 5) < 3) {
            res = "зеленый";
        } else if ((tmp % 5) >= 3 && (tmp % 5) < 4) {
            res = "желтый";
        } else if ((tmp % 5) >= 4 && (tmp % 5) <= 5) {
            res = "красный";
        }
        System.out.println(res);
    }
}