package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap();
        // ключ - значение
        // Last Name - фамилия _ First Name - имя
        // 2 пары IDE или JVM сами уберут т.к. ключи уникальны, так что 12 строк а не 10
        map.put("Thanos", "Prostofarianec");
        map.put("Nebula", "Titan");
        map.put("Thanos", "Mars");
        map.put("Gomora", "Prostofarianec");
        map.put("Djeen", "Gray");
        map.put("Thanos", "Mercury");
        map.put("Ironman", "Prostofarianec");
        map.put("Spiderman", "Venus");
        map.put("Luck", "Skyuvoker");
        map.put("Dart", "Veider");
        map.put("Dart2", "Veider");
        map.put("Dart3", "Veider");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код // имя
        //        Iterator it = map.entrySet().iterator();
////        Object st;
//        while(it.hasNext()){
////            Entry st = it.next();
//        } // Entry нет такого класса откуда брать !?
        int res = 0;
        String tmp;
        for (Map.Entry<String, String> item : map.entrySet()) {
            tmp = item.getValue();
            if (tmp.equals(name)) {
                res++;
            }
        }
//        res = Collections.frequency((Collection<String>) map, name); // не работает подсчет в карте значений
        return res;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код // фамилия _ key
        return map.containsKey(lastName) ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(getCountTheSameFirstName(createMap(), "Prostofarianec")); // 2
        System.out.println(getCountTheSameLastName(createMap(), "Thanos")); // 1 потому что ключи уникальны
    }
}
