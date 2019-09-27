package com.javarush.task.task16.task1612;

/* 
Stopwatch (Секундомер)
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Runner ivanov = new Runner("Ivanov", 4);
        Runner petrov = new Runner("Petrov", 2);
        //на старт!
        //внимание!
        //марш!
        ivanov.start();
        petrov.start();

        // в конструкторе Runner запускается поток в конструктор Stopwatch класса
//        ivanov.stopwatch.join();

        Thread.sleep(2000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Stopwatch extends Thread {
        private Runner owner;
        private int stepNumber;

        public Stopwatch(Runner runner) {
            this.owner = runner;
        }

        public void run() {
            try {
                while (!isStopped) {
                    doStep();
                }
            } catch (InterruptedException e) {
            }
        }

        private void doStep() throws InterruptedException {
            stepNumber++;
            //add your code here - добавь код тут
            long stepPerSecond = owner.getSpeed();
            long sleepTime = 1000 / stepPerSecond;

            // т.е. как бы намекают что использовать явно не цикл
            // Метод doStep должен учитывать скорость бегуна. Если скорость бегуна 2 шага в секунду, метод должен
            // работать пол секунды; если скорость бегуна 4 шага в секунду, метод должен работать четверть секунды.
//            for (int i = 0; i < stepPerSecond; i++) {
//                Thread.sleep(sleepTime);
//                System.out.println(owner.getName()+" "+stepsM);
//            }

            Thread.sleep(sleepTime);
            System.out.println(owner.getName() + " делает шаг №" + stepNumber + "!");
        }
    }

    public static class Runner {
        Stopwatch stopwatch;
        private String name;
        private int speed;

        public Runner(String name, int speed) {
            this.name = name;
            this.speed = speed;
            this.stopwatch = new Stopwatch(this);
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public void start() {
            stopwatch.start();
        }
    }
}
