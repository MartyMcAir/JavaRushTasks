package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2504#discussion
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thred : threads) {
            switch (thred.getState()) {
                case NEW:
//                    System.out.println("case NEW: " + thred.getState());
                    thred.start();
                    break;
                case BLOCKED:
                case WAITING:
                case TIMED_WAITING:
//                    System.out.println("case TIMED_WAITING: " + item.getState());
                    thred.interrupt();
//                    System.out.println(thred.getPriority());
                    break;
                case RUNNABLE:
//                    System.out.println("case RUNNABLE: " + item.getState());
                    thred.isInterrupted();
//                    if (thred.isInterrupted()) {
//                        System.out.println(thred.getPriority());
//                    }
                    break;
                case TERMINATED:
//                    System.out.println("case TERMINATED: " + item.getState());
                    System.out.println(thred.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            public void run() {
                Thread thrCurrent = Thread.currentThread();
                System.out.println(thrCurrent.getName() + ", condition: " + thrCurrent.getState());
            }
        };
        Thread[] tArr = new Thread[10];
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = new Thread(r1);
        }


//        for (int i = 0; i < tArr.length; i++) {
//            tArr[i].start();
////            Thread.currentThread().sleep(1000);
//            tArr[i].join();
//        }
        processThreads(tArr);

    }
}
