package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код _ Scanner .. nextInt();
        int interations=5;
        int[] arrInt = new int[interations];
        for(int i=0; i<interations; i++){
            arrInt[i]=Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arrInt);
//        System.out.println(Arrays.toString(arrInt)); // [5, 23, 23, 43, 63]
        for(int i=0; i<interations; i++){
            System.out.println(arrInt[i]);
        }
        // OR _ пузырьковая сортировка? _ но она затратна в сравнении с Arrays.sort
    }
}
