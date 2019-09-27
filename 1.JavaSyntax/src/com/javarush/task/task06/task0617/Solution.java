package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    //напишите тут ваш код
    // будет выводить на экран описание идеи - это то, что возвращает метод getDescription
    public static void printIdea(Idea idea){
        System.out.println(idea.getDescription());
    }
    public static class Idea{
        public String getDescription(){  //  будет возвращать любой непустой текст
            String res="idea";
            return res;
        }
    }
}
