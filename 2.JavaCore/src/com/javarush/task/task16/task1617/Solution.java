package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
//        Thread current = Thread.currentThread();
    }

    public static class RacingClock extends Thread {

        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            int i = numSeconds;
            while (numSeconds>=1) {
                try {
                    Thread.sleep(1000);
                    System.out.print((numSeconds--) + " ");
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.print((numSeconds--) + " ");
                    System.out.println("Прервано!");
                }
            }
            if (i == 3) {
                System.out.println("Марш!");
            }
        }
    }
}
