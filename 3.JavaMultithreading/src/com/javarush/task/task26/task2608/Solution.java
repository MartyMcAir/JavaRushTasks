package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать
*/
// https://javarush.ru/tasks/com.javarush.task.task26.task2608#discussion
// Все методы, кроме метода main, класса Solution должны быть thread safe.
//Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными тредами.
//synchronized(this) для этого не подходит, используй другой объект для лока.
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
//        synchronized (lock1and2) { // тож подходит
        synchronized (this) {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        synchronized (Solution.class) {
            return var3 + var4;
        }
    }

    public static void main(String[] args) {

    }
}
