package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name = "";
        private int age = 0;
        private boolean sex = true;
        private double weight = 13.3;
        private char faivoriteSymbol = '$';
        private long capital = 999;
        // 1
        public Human(String name, int age, boolean sex, double weight, char faivoriteSymbol, long capital) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.faivoriteSymbol = faivoriteSymbol;
            this.capital = capital;
        }
        // 2
        public Human(String name, int age, boolean sex, double weight, char faivoriteSymbol) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.faivoriteSymbol = faivoriteSymbol;
        }
        // 3
        public Human(String name, int age, boolean sex, double weight) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
        }
        // 4
        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        // 5
        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }
        // 6
        public Human(String name) {
            this.name = name;
        }
        // 7
        public Human(long capital) {
            this.capital = capital;
        }
        // 8
        public Human(char faivoriteSymbol, long capital) {
            this.faivoriteSymbol = faivoriteSymbol;
            this.capital = capital;
        }
        // 9
        public Human(double weight, char faivoriteSymbol, long capital) {
            this.weight = weight;
            this.faivoriteSymbol = faivoriteSymbol;
            this.capital = capital;
        }
        // 10
        public Human(boolean sex, double weight, char faivoriteSymbol, long capital) {
            this.sex = sex;
            this.weight = weight;
            this.faivoriteSymbol = faivoriteSymbol;
            this.capital = capital;
        }
    }
}
