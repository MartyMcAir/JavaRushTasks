package com.javarush.task.task25.task2514;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2514#discussion
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
//            Thread.yield(); // без yield() и join() вывод рандомен
            System.out.println("end-" + index);
//            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            YieldRunnable yr = new YieldRunnable(i);
            Thread t1 = new Thread(yr);
            t1.start();
//            t1.join(); // обеспечивает: 0 0, 1 1.. и без yield()
            // валидатор принял с Thread.sleep(100); - с первого раза
            Thread.sleep(100); // обеспечивает: 0 0, 1 1.. и без yield() и без join()
//            t1.interrupt(); // обеспечивает 0 0, 3 3.. и без yield() и join() - но не попорядку
        }

        // эффект от ..yield() - особо не стабилен

        // еще вариант проверки..
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 1; i <= 100; i++) {
            service.execute(new YieldRunnable(i));
        }
        service.shutdown();
    }
}
