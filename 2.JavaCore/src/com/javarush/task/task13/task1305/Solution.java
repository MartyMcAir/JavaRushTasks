package com.javarush.task.task13.task1305;

/* 
Четыре ошибки
*/

public class Solution {

    public static void main(String[] args) {
//        Dream dr = new Hobby();
//        System.out.println(dr.HOBBY.toString());  // 2 __ 3
        System.out.println(Dream.HOBBY.toString()); // 2
        System.out.println(new Hobby().toString());  // 2

    }

    interface Desire {
    }

     interface Dream { // работает и без static
        public Hobby HOBBY = new Hobby();
    }

    static class Hobby implements Dream, Desire {
        public int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}
