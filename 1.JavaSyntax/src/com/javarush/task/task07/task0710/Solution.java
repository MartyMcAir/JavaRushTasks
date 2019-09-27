package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>(10); // 10 элементов начальная емкость

        int n = list.size();
        for (int i = 0; i < 10; i++) {
            String s = bf.readLine();
//            list.add(list.size() - i, s);
            list.add(0, s);
        }

//        String[] arrStr = new String[10];
//        for (int i = 0; i < 10; i++) {
//            arrStr[i] = bf.readLine();
//        }
//        Collections.fill(list, "t"); //

//        for (int i = 0, j = 9; i < 10; i++, j--) {
//            list.add(arrStr[j]);
//            list.add(bf.readLine());
//            list.add(i, bf.readLi=ne());
//            list.set(i, bf.readLine());
//        }
//        Collections.rotate(list, 10); // не подходит
//        list.sort(Collections.reverseOrder()); // тоже вариант _ но это не соответствует условиям т.е. добавка в колл..

        list.forEach((z) -> System.out.println(z));

//        System.out.println(list.toString());
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
    }
}
