package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        Map<String, Person> map = new HashMap<>();
        map.put("user", new Person.User());
        map.put("loser", new Person.Loser());
        map.put("coder", new Person.Coder());
        map.put("proger", new Person.Proger());

        while (true) {
            key = reader.readLine();
            if (map.containsKey(key)) {
                //создаем объект, пункт 2
                person = map.get(key);
                doWork(person); //вызываем doWork
            } else {
                break;
            }
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof Person.User){
//            new Person.User().live();
            ((Person.User) person).live(); // считает это более правильным вариантом
            // нисходящее сужающее приведение
        }
        if(person instanceof Person.Loser){
//            new Person.Loser().doNothing();
            ((Person.Loser) person).doNothing();
        }
        if(person instanceof Person.Coder){
//            new Person.Coder().writeCode();
            ((Person.Coder) person).writeCode();
        }
        if(person instanceof Person.Proger){
//            new Person.Proger().enjoy();
            ((Person.Proger) person).enjoy();
        }
    }
}
