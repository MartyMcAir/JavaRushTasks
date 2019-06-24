package com.javarush.task.task12.task1204;

/* 
То ли птица, то ли лампа
*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
        String res = null;
        if( o instanceof Cat){
            res="Кошка";
        }
        if( o instanceof Dog ){
            res="Собака";
        }
        if( o instanceof Bird){
            res="Птица";
        }
        if (o instanceof Lamp){
            res="Лампа";
        }
        System.out.println(res);
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
