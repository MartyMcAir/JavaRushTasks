package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = new Integer[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr)); // 2 3 7

        Arrays.sort(arr, Collections.reverseOrder());
        // System.out.println(Arrays.toString(arr)); // 7 3 2
/*        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i] + " ");
        }*/

// можно без обратной сортировки вывести массив просто в обратномпорядке через цикл
        // без reverseOrder()
        for (int i = 2; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
