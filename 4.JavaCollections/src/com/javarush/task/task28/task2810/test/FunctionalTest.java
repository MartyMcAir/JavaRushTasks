package com.javarush.task.task28.task2810.test;

public class FunctionalTest {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            counter++;
        }
        System.out.println("counter: " + counter);
        for (int i = 0; i < 10; i++) {
            counter++;
        }
        System.out.println("counter: " + counter);
    }
}
