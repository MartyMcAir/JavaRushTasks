package com.javarush.task.task34.task3405;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* 
Мягкие ссылки
*/
// https://javarush.ru/tasks/com.javarush.task.task34.task3405#discussion
public class Solution {
    public static Helper helper = new Helper();

    public static void main(String args[]) throws InterruptedException {
        helper.startTime(); // старт отсчета времени.. System.currentTimeMillis()

        Monkey monkey = new Monkey("Simka"); // обычный объект с полем name

        //Add reference here // мягкая ссылка _ которую удалят в случае нехватки памяти
        SoftReference<Monkey> reference = new SoftReference<>(monkey);
        helper.callGC();    // System.gc() - вызов Garbage Collector

        monkey = null; // присвоение ссылке null, терь на объект есть только мягк ссылка

        helper.callGC();  // ..
        helper.consumeHeap();// пока false, список напоняется объектом и далее код не идет..

        if (reference.get() == null)  //
//        while (reference.get() != null)  // работает и без цикла
            System.out.println("Finalized");

        helper.finish();
    }

    public static class Helper {
        public static boolean isFinalized;
        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        void consumeHeap() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                while (!isFinalized) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("An out-of-memory exception has occurred");
            }
        }

        public void finish() {
            System.out.println("Done");
            System.out.println("It took " + getTime() + " s");
        }
    }

    public static class Monkey {
        private String name;

        public Monkey(String name) {
            this.name = name;
        }

        protected void finalize() {
            Helper.isFinalized = true;
            System.out.format("Bye-Bye, %s!\n", name);
        }
    }
}
