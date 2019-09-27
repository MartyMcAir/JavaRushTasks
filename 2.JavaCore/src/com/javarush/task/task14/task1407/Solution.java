package com.javarush.task.task14.task1407;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Player and Dancer
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;
        String key;
        while (!(key = reader.readLine()).equals("exit")) {
            if ("player".equals(key)) {
                person = new Player();
            } else if ("dancer".equals(key)) {
                person = new Dancer();
            }
            haveFun(person);
        }
    }

    public static void haveFun(Person person) {
        //напишите тут ваш код
        if(person instanceof Player){
            person.play();
        }
        if(person instanceof Dancer){
            person.dance();
        }

//        if(person.getClass().getSimpleName().trim().equalsIgnoreCase("Player")){
//            person.play();
//        }
//        if(person.getClass().getSimpleName().trim().equalsIgnoreCase("Dancer")){
//            person.dance();
//        }
    }

    interface Person {
        // code
        void play();
        void dance();
    }

    static class Player implements Person {
        // code
        @Override
        public void play() {
            System.out.println("playing");
        }

        @Override
        public void dance() {
        }
    }

    static class Dancer implements Person {
        // code
        @Override
        public void dance() { System.out.println("dancing"); }

        @Override
        public void play() {
        }
    }
}
