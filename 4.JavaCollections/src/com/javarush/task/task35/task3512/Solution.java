package com.javarush.task.task35.task3512;

/* 
Генератор объектов
*/
public class Solution {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        Generator<Event> eventGenerator = new Generator<>(Event.class);
        Generator<Event> eventGenerator = new Generator<Event>(Event.class);
        eventGenerator.newInstance();

        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());

//        Generator<Event> eventGenerator2 = new Generator<>(new Event());
//        eventGenerator2.newInstance();
//        Generator<Event> eventGenerator3 = new Generator<>();
//        eventGenerator3.newInstance().getId();
//        eventGenerator3.newInstance2().getId();
    }
}
