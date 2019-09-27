package com.javarush.task.task16.task1610;

/* 
Расставь вызовы методов join()
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Пушинка");
        cat2.join();
    }

    private static void investigateWorld() {
        try {
            Thread.sleep(200);
//            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) throws InterruptedException {
            super(name);
            kitten1 = new Kitten("Котенок 1, мама - " + getName());
            kitten2 = new Kitten("Котенок 2, мама - " + getName());
            start(); // Запуск потока
        }

        public void run() {
            System.out.println(getName() + " родила 2 котенка");
            try {
                initAllKittens(); // запуск кошек _ инициализация
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start();
            kitten2.start();
            // Сначала котята пушинки должны вылезти из корзины, после этого она сможет их собрать.
            // Особо ничего не понял
            kitten1.join();
            kitten2.join();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
//            if(Thread.currentThread().getName().equalsIgnoreCase("Пушинка")){
//                try {
//                    Thread.currentThread().join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(getName() + ", вылез из корзинки");
            investigateWorld();
        }
    }
}
