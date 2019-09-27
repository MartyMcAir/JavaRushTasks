package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine()), check = 0;

        for (int i = 0; i < N; i++) {
            list.add(reader.readLine());
        }

        for (int i = 0, j = 0; i < N; i++, j++) {
            if(M>check){
                list.add(list.remove(0));
                // Допустим m=5, будет цикл от 0 до 4 (т.е. сделает 5 проходов 0,1,2,3,4)
                // И каждый проход нулевой элемент списка будет добавляться в конец и удаляться,
                // после удаления нулевым станет первый (список сместится).
                // Очень просто - в конец списка добавляется первый элемент и тут же удаляется из начала списка.
                // По сути перестановка элемента местами.
                check++;
            }
        }

        for(String st : list){
            System.out.println(st);
        }
    }
}
