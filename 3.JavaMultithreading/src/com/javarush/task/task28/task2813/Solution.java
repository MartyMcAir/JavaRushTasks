package com.javarush.task.task28.task2813;

import java.util.concurrent.*;

/* 
FutureTask
*/

public class Solution {
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);
    private static final int n = 16;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        FactorialCalculator task = new FactorialCalculator(n);

        System.out.println("Submitting Task ...");
        // Отправляем в фиксированный пул задание
        Future future = threadpool.submit(task);   // Future возвращает Future
        System.out.println("The task was submitted successfully");

        while (!future.isDone()) { // выводим сообщение пока задания, не будут готовы
            System.out.println("The task is not done yet....");
            Thread.sleep(1);
        }

        System.out.println("The task is done. Let's check the result");
        long factorial = (long) future.get(); // достаем из Future результ выполнения

        System.out.println("Factorial of " + n + " is " + factorial);
        threadpool.shutdown(); // запрещаем добавление нов заданий
    }
}
