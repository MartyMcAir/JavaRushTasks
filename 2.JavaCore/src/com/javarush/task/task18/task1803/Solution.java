package com.javarush.task.task18.task1803;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String file_path = bf.readLine();
        String file_path = "C:\\z_n\\new_test_folder\\file_name.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(file_path));

//        ArrayList<Integer> listKey = new ArrayList<Integer>();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key, value, maxKeyRepeat = 0; //, maxValue = 1 1повтор это миним _ maxKeyRepeat-0 байт это мин
        while (bfIn.available() > 0) {
            key = bfIn.read();
//            listKey.add(key);
//            if (map.containsKey(key)) { // еслм ключ есть
//                value = map.get(key);
//                map.put(key, (value + 1)); // то вставляем ключ с новым значением значением
//
//                if ((value + 1) > maxValue) { // если текущ value больше сохраненного то меняем..
//                    maxValue = (value + 1);
////                    maxKeyRepeat = key; // данный ключ имеет найбольшее кол-во повторов
//                }
//            } else {
//                map.put(key, 1);
//            }
            map.merge(key, 1, Integer::sum); // продвинутый вариант с комментов
        }
        bf.close();
        bfIn.close();

//        for (int i = 0; i < maxValue; i++) { // Не нужно несколько раз выводить один и тот же байт
//        }
//        System.out.print(maxKeyRepeat + " "); // выборка на один ключ

        int maxValue = Collections.max(map.values()); // продвинутый вариант с комментов

//        ArrayList<Integer> listMaxKey = new ArrayList<Integer>();
        for (int item : map.keySet()) {   // выборка для вывода всех ключей с max кол-вом повторов
            if (map.get(item) == maxValue) {
//                listMaxKey.add(item);
                System.out.print(item+" ");
            }
        }
//        listMaxKey.forEach(v -> System.out.print(v + " "));

//        System.out.println("\n--- --- ---");
//        map.forEach((k, v) -> System.out.println(k + " " + v));
//
//        listKey.forEach((v) -> System.out.print(v + " "));


//        System.out.println("\n--- --- ---");
//        ArrayList<Integer> listValue = new ArrayList<Integer>(map.values());
//        listValue.forEach((v) -> System.out.print(v + " "));
//
//        Collections.sort(listValue);
//        System.out.println("\n--- --- ---");
//        listValue.forEach((v) -> System.out.print(v + " "));

//        map.forEach((k, v) -> System.out.println(v));

    }
}
