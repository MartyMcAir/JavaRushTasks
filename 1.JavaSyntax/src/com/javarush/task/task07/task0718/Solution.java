package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
//        Collections.addAll(list, "", "a", "aa", "aaa", "a", "aa");
//        Collections.addAll(list, "aa", "aaa", "aaaa", "a", "aa");

        for (int i = 0; i < 10; i++) {
            list.add(bf.readLine());
        }

        int j = 0, count = 0, check = list.get(0).length();
        String start;
        // for "aa", "aaa", "aaaa", "a", "aa"
        for (int i = 0; i < list.size(); i++) {
            start=list.get(i);
            if (start.length() == check) {
                check++;
            } else {
//                System.out.println(list.get(i)+" i "+i);
                System.out.println(list.indexOf(list.get(i))+1);
                // Индексация с 0 начинается, а не с 1, а проверка в задаче думает иначе.
                //  Если нарушен порядок вторым элементом, то вывести нужно 2, а не 1, хотя индекс идет: 0, 1, 2...
                // В описании действительно ошибка. В условии сказано вывести индекс элемента, нарушающего
                // упорядоченность, так валидация не проходит. По факту проходит валидацию с указанием номера строки вместо индекса.
                break;
            }
        }

        // for "", "a", "aa", "aaa", "a", "aa"
//        while(j<list.size()){
//            if(list.get(j).length() == count){
//                count++;
//            } else{
//                System.out.println(list.get(j)+" j: "+j);
//                break;
//            }
//            j++;
//        }

//        for(String n : list){
//            if(n.length() == count){
//                count++;
//            } else{
//                System.out.println(list.get(j)+" j: "+n);
//                break;
//            }
//        }

    }
}

