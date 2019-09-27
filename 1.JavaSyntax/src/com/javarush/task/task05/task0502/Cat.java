package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        boolean res = false;
        int cat1 = 0, cat2 = 0;
        if (this.age > anotherCat.age) {
            cat1++;
        } else if (this.age < anotherCat.age) {
            cat2++;
        }
        if (this.weight > anotherCat.weight) {
            cat1++;
        } else if (this.weight < anotherCat.weight) {
            cat2++;
        }
        if (this.strength > anotherCat.strength) {
            cat1++;
        } else if (this.strength < anotherCat.strength) {
            cat2++;
        }
        res = (cat1 > cat2) ? true : false;

        return res;
    }

    public static void main(String[] args) {
        Cat vasya = new Cat();
        vasya.age = 3;
        vasya.weight = 3;
        Cat tanos = new Cat();
        tanos.age = 6;
        tanos.weight = 6;
        tanos.strength = 6;
        vasya.strength = 3;

        Cat vasya2 = new Cat();
        vasya2.age = 3;
        vasya2.weight = 3;
        vasya2.strength = 3;

        System.out.println(vasya.fight(tanos)); // false
        System.out.println(tanos.fight(vasya)); // true
        System.out.println(vasya2.fight(vasya)); // false
    }
}
