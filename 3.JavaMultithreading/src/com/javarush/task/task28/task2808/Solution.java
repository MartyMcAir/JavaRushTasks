package com.javarush.task.task28.task2808;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/* 
Осваиваем Callable
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>(); // список задач
        // запускатор с макс кол-вом пулов 5
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) { // добавляем задания в список
            futures.add(executor.submit(getTask(i)));
        }
        // добавляем последнее задание с оч. длинным числом
        futures.add(executor.submit(getTask(10000000)));

        for (Future<String> future : futures) {
            // перебираем список Future<String> и получаем рещульт работ,
            // через его метод get()
            System.out.println(future.get());
        }

        executor.shutdown(); // запрещаем добавление новыз заданий
        executor.awaitTermination(10, TimeUnit.SECONDS); // даем 10 сек навыполнение

/* output
500500
501501
502503
503506
504510
505515
506521
507528
508536
509545
510555
50000005000000
*/
    }

    public static Callable<String> getTask(final int i) {
        final long[] res = {0};
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
//                return String.valueOf(res[0] += i);
                return String.valueOf(BigInteger.valueOf((long)((i*1.0*(i+1.0))/2.0)));
            }
        };
    }
}
