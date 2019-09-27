package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        Cat tanos = new Cat("Tanos", 3000, 1500, 888);
        Cat hulk = new Cat("Hulk", 60, 2000, 666);
        Cat thor = new Cat("Thor", 3500, 1100, 999);
        System.out.println(tanos.fight(hulk));
        System.out.println(tanos.fight(thor));
        System.out.println(thor.fight(tanos));
//        System.out.println(thor.fight(hulk));
//
//        System.out.println(hulk.fight(thor));
//        System.out.println(hulk.fight(tanos));
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score >= 2; // return score > 2 ? true : false; ___ добавил знак = в >=
        }
    }
}
