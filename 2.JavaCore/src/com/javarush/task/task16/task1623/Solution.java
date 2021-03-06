package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount; // volatile одна переменная на все потоки

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
//        if(count==0){
//            Thread.currentThread().interrupt();
//        }
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            // Конструктор класса GenerateThread должен передавать увеличенное значение createdThreadCount
            // в качестве имени в конструктор суперкласса. _ а не createdThreadCount++
            // т.е. сначала увеличиваем значение, а потом передаем
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
//            int i = 1;
//            while (i < count) {
////                System.out.println(this); // выодит 15 штук с нулями
//                System.out.println(new GenerateThread()); // выодит бесконечное кол-во с кучей цифр
//                i++;
//                if (i == count) {
//                    interrupt();
//                }
//            }
            // в методе "run" не используйте цикл  "fori" т.к. при создании каждой нити "run" запускается новый и цикл
            // "run"начинается с нуля...вот тебе и бесконечная история, пока память не закончится...
//            while(count>createdThreadCount){
//                System.out.println(new GenerateThread());
//            }

            // Если количество созданных нитей меньше Solution.count, метод run должен
            // создать новую нить типа GenerateThread.
            if(createdThreadCount<count){
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
