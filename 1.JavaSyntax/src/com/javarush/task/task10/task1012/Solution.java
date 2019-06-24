package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
//        Collections.addAll(list, "микробиология программирования", "кибернетика", "бионика",
//                "оптогенетика", "программирование днк");
//        Collections.addAll(list, "а", "бб", "ввв", "гггг", "ддддд", "ееееее",
//                "ёёёёёёё", "жжж жжж жж", "ззз ззз ззз", "иии иии иии и"); // 1 2 3 4 5 6 7 8 9 10
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (char ch : alphabet) {
            map.put(ch, 0);
        }
//        System.out.println(map);

        String tmpStr;
        char tmpCh, tmpChMap;
        char[] arrCh;
        for (int i = 0; i < list.size(); i++) { // перебираем 10 list строк
            tmpStr = list.get(i).trim().toLowerCase();
            arrCh = tmpStr.toCharArray();

            for(int j=0; j<arrCh.length; j++){ // перебираем массив символов текущей строки
                tmpCh=arrCh[j];

                for(Map.Entry<Character, Integer> pair : map.entrySet()){ // перебираем map алфавита
                    if(pair.getKey().equals(tmpCh)){   // если совпало то добавляем в value +1
                        map.put(pair.getKey(), pair.getValue()+1);
                    }
                }
            }
        }

//        System.out.println(map);
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character, Integer> pair = it.next();
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
    }

}
