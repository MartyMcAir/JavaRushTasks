package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        int r = ThreadLocalRandom.current().nextInt(from, to);
        return r;
    }

    public static double getRandomDouble() {
        double r = ThreadLocalRandom.current().nextDouble();
        return r;
    }

    public static long getRandomLongBetween0AndN(long n) {
        long r = ThreadLocalRandom.current().nextLong(0, n);
        return r;
    }

    public static void main(String[] args) {
    }
}
