package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        Cat tanos = new Cat("tanos", 3000, 1500, 9999);
        Cat nebula = new Cat("nebula", 800, 500, 666);
        Cat gomora = new Cat("gomora", 600, 600, 888);

    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}