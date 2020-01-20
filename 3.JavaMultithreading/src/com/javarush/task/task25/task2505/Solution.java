package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2505#discussion
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        //
        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } finally {
//                System.out.printf("%s, %s, %s", secretKey, name, cause);
                    String name = t.getName();
//                    String cause = e.getCause().toString();
                    String cause2 = e.getLocalizedMessage();
                    String secretKey = MyThread.this.secretKey;
                    System.out.println(String.format("%s, %s, %s", secretKey, name, cause2));
                }
            }
        }
    }

}

