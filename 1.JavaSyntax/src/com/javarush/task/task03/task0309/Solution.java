package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        sumProgress(1, 5);
    }

    public static void sumProgress(int st, int end) {
        int tmp, res, tmp2 = 0;
        for (int i = st; i <= end; i++) {
            tmp = st;
            tmp2 += st; // 15
            res = st + tmp; // 10
            System.out.println(tmp2);
            st++;
        }
    }

}
