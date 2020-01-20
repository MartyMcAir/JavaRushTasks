package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;   // volatile _ одна переменная на все потоки

        public static List<String> steps = new ArrayList<String>();

        static {   // статик блок инициализации _ наполение коллекции
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() { // Внутри потока OnlineGame запускаем потоки Gamer
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) { // если false, то потоки работают пока не найдется победитель
            }
            // прерываем потоки
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);   // имя потока
            this.rating = rating;
        }

        @Override
        public void run() {
            //Add your code here - добавь код тут
            int i = 0;
            try {
                while (i < OnlineGame.steps.size()) {
                    Thread.sleep(1000 / rating);

                    System.out.println(getName() + ":" + OnlineGame.steps.get(i));
                    i++;
                    // если это последний шаг текущего потока, то данный поток победитель
                }

                // можно его не создавать, а просто в условии елзе вывести сообщения
                // проигравших в блок кэч оставить пустым
                if (!OnlineGame.isWinnerFound) {
                    OnlineGame.isWinnerFound = true;
                    System.out.println(getName() + ":победитель!");
                } else throw new InterruptedException();

//                if (!OnlineGame.isWinnerFound) {
//                    Thread.sleep(1000 / rating);
//                    System.out.println(getName() + ":победитель!");
//                }
//
//                if (i == OnlineGame.steps.size()) {
//                    // Игрок не должен выводить сообщение о победе, если переменная isWinnerFound
//                    // уже установлена в true (победитель уже найден)
//
//                    // Метод run должен засыпать на (1000ms / rating) четыре раза.
////                        Thread.sleep(1000 / rating);
////                        System.out.println(getName() + ":победитель!");
//                    OnlineGame.isWinnerFound = true;
//                }

            } catch (InterruptedException e) {
                System.out.println(getName() + ":проиграл!");
            }
        }
    }
}
