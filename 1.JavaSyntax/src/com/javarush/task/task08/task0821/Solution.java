package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        // добавлять в словарь 10 человек. _ "Фамилия"-"Имя"
        Map<String, String> map = new HashMap<String, String>();
        map.put("Chan", "Djeky");
        map.put("King", "Steven");
        map.put("Stakham", "Djeison");
        map.put("Nikkolson", "Djek");
        map.put("Stalone", "Silvester");
        map.put("Swatzneger", "Arnold");
        map.put("Smitt", "Will");
        map.put("Merfy", "Bob");
        map.put("Presly", "Bob");
        map.put("Presly", "Elvis");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
