package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
//        Collections.addAll(list, 2, 4, 4, 4, 8, 8, 4, 12, 12, 14); // 3 и 2
//        Collections.addAll(list, 1, 1, 1, 2, 2, 1, 1, 1, 1, 3, 3); // 4 и 3 по 1
//        Collections.addAll(list, 1, 2, 2, 3, 3, 3); //  1 2 3
//        Collections.addAll(list, 2, 2, 3, 3, 3); //  1 2 3

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextInt());
        }

        int count1 = 1, current = 0, tmp, future = list.get(0);
        int[] arrInt = new int[list.size() + 2];

        for (int i = 1; i < list.size(); i++) {
            tmp = future = list.get(i);
            if (i >= 1) {
                current = list.get(i - 1);
                if (list.size() == (i + 1)) {
                    if (current == future) {
                        count1++;
                    } else if(current!=future){
                        arrInt[i+1]=1;
                    }
                    arrInt[i] = count1;
                }
                if (current == future) {
                    count1++;
                } else if (current != future) {
                    arrInt[i] = count1;
                    count1 = 1;
                }
            }
        }
        Arrays.sort(arrInt);
//        System.out.println(Arrays.toString(arrInt));
        System.out.println(arrInt[arrInt.length-1]);
    }
}