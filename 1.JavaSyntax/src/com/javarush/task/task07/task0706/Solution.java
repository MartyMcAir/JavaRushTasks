package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int[] arrInt = new int[15];
        int tmp, even = 0, odd = 0;
        //  Пускай индекс элемента массива является номером дома, а значение - число жителей, проживающих в доме.
        // Дома с нечетными номерами расположены на одной стороне улицы, с четными - на другой.
        for (int i = 0; i < 15; i++) {
            tmp = sc.nextInt();
            arrInt[i] = tmp;
            if ((i % 2) == 0 || i == 0) { // не tmp а i т.е. индекс элемента на четность
                even += tmp;
            } else if ((i % 2) != 0) {
                odd += tmp;
            }
        }
        String res = even > odd ? "В домах с четными номерами проживает больше жителей." :
                "В домах с нечетными номерами проживает больше жителей.";
        System.out.println(res);

    }
}
