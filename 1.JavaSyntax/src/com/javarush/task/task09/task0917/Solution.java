package com.javarush.task.task09.task0917;

/* 
Перехват unchecked-исключений
*/

public class Solution {
    public static void main(String[] args) {
        handleExceptions(new Solution());
    }

    public static void handleExceptions(Solution obj) {
        try { // код
            obj.method1();
            obj.method2();
            obj.method3();
        } catch (RuntimeException e){ // код
//            StackTraceElement[] st = Thread.currentThread().getStackTrace();
//            thr.printStackTrace();
//            thr.getStackTrace();
            Throwable thr = new Throwable();
//            System.out.println(thr.getMessage());
            printStack(e);
        }
    }

    public static void printStack(Throwable throwable) {
        System.out.println(throwable);
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element);
        }
    }

    public void method1() {
        throw new NullPointerException();
    }

    public void method2() {
        throw new IndexOutOfBoundsException();
    }

    public void method3() {
        throw new NumberFormatException();
    }
}

