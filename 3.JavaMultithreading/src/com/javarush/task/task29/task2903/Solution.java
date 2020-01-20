package com.javarush.task.task29.task2903;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;

/* 
И еще раз рефакторинг
*/
// https://javarush.ru/tasks/com.javarush.task.task29.task2903#discussion
public class Solution {
    // from comments
    // Может кто то как и я затупил)
    //Числа получаются одинаковые, т.к. ThreadLocalRandom для каждого thred-a генерирует свой поток,
    // и когда в одном thread-е мы берём nextInt(), то это не отражается на числах в другом потоке.
    // А так как у нас ThreadLocalRandom уже задан вне потоков в начале, то в каждом thread-e
    // мы можно сказать работает с копиями ThreadLocalRandom из static final.

    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(getRunnable(i, concurrentMap)).start();
        }
        sleepOneSecond();
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Runnable getRunnable(final int i, final ConcurrentMap<Integer, String> concurrentMap) {
        return new Runnable() {
            @Override
            public void run() {
                final String name = "Thread #" + i;
                int randomInt = RANDOM.nextInt(20);
                String text = name + " вставил запись для " + randomInt;

                // previousEntry is null for new entries
                /* Instead of setting it to null, call concurrentMap.someMethod(randomInt, text) */
//                String previousEntry = null;
//                String previousEntry = concurrentMap.put(randomInt, text);

                // почему именно тут до проверки и именнно putIfAbsent()!?
                String previousEntry = concurrentMap.putIfAbsent(randomInt, text);
// добавляет один элемент, не изменяя значение существующего элемента. Метод возвращает значение null,
// если ключа не было в словаре, и старое значение, если ключ существует в словаре
// (при этом старое значение не заменяется новым).

                if (previousEntry != null) {
//                    concurrentMap.put(randomInt, text);
                    System.out.println(name + " хочет обновить " + randomInt + ", однако уже " + previousEntry);
                } else {
                    System.out.println(text);
                }
            }
        };
    }
}
