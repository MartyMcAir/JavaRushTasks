package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
//        Collections.addAll(words, "java", "java", "best", "way", "anyway", "way"); //
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //напишите тут ваш код
        //  (большая/маленькая буква) влияет на результат
        for (String st : list) {
            result.put(st.trim(), 0);
        }
        String tmp;
        for (int i = 0; i < list.size(); i++) {
            tmp = list.get(i).trim();
            for (Map.Entry<String, Integer> pair : result.entrySet()) {
                if (pair.getKey().equals(tmp)) {
                    result.put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        return result;
    }
}

