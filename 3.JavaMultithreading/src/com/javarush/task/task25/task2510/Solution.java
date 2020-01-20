package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        // OR _ с помощью лямюды принял а анонимный класс НЕТ
        // или не хватало else if
        setUncaughtExceptionHandler((t, e) -> {
            if (e instanceof Error) {
                System.out.println("Нельзя дальше работать");
            } else if (e instanceof Exception) {
                System.out.println("Надо обработать");
            } else if (e instanceof Throwable) {
                System.out.println("Поживем - увидим");
            }
        });
    }

    public static void main(String[] args) {
        // OR
//        new Solution().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                if (e instanceof Error) {
//                    System.out.println("Нельзя дальше работать");
//                }
//                if (e instanceof Exception) {
//                    System.out.println("Надо обработать");
//                }
//                if (e != null) {
//                    System.out.println("Поживем - увидим");
//                }
//            }
//        });
//
//        new Thread() {
//
//        };
    }

    // OR _ через создание класса обработчика
    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }

}
