package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Thanos", 3000);
        map.put("Nebula", 300);
        map.put("Gomora", 300);
        map.put("Barry", 1600);
        map.put("Bruce", 2600);
        map.put("Faraday", 6000);
        map.put("Piter", 1100);
        map.put("Rodgers", 800);
        map.put("Ksovier", 2300);
        map.put("Magnetto", 2800);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
//        System.out.println(map);
//        map.values().removeIf((v)->(v<500)); // work

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); // work
        while(it.hasNext()){
            Map.Entry<String, Integer> pair = it.next();
            if(pair.getValue()<500){
                it.remove();
            }
        }

//        for(Map.Entry<String, Integer> pair : map.entrySet()){
//            if(pair.getValue()<500){
////                map.remove(pair.getKey()); // ConcurrentModificationException
//            }
//        }

//        System.out.println(map);
    }

    public static void main(String[] args) {
//        removeItemFromMap(createMap());
    }
}