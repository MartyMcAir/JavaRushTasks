package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
//        String res = null;
        BigInteger res = BigInteger.ONE;
        if (n < 0) {
            res = BigInteger.ZERO;
        }
        if (n == 0) {
            res = BigInteger.ONE;
        }

        for (int i = 1; i <= n; ++i) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res.toString();
    }
}
