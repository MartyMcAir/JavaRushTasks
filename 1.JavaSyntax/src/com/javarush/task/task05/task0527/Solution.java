package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //напишите тут ваш код
        Dog bob = new Dog("Bob", 23, false);
        Cat tom = new Cat("Tom", 16, true);
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код
    public static class Dog{
        String name;
        int height;
        boolean smart;

        public Dog(String name, int height, boolean smart){
            this.name=name;
            this.height = height;
            this.smart=smart;
        }
    }

    public static class Cat{
        String name;
        int height;
        boolean smart;

        public Cat(String name, int height, boolean smart){
            this.name=name;
            this.height=height;
            this.smart=smart;
        }
    }
}
