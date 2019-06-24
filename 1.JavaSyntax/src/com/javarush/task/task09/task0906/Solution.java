package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
//        s+=Thread.currentThread().getClass()+": class "; // java.lang.Thread
//        res+= Object.class; // class java.lang.Object

        // 0-java.lang.Thread _ 1-com.javarush.task.task09.task0906.Solution
        // com.javarush.task.task09.task0906.Solution
        String res = Thread.currentThread().getStackTrace()[2].getClassName() + ": "; // тут должен быть елемент 2
        res += Thread.currentThread().getStackTrace()[2].getMethodName() + ": "; // main
        System.out.println(res + s);
    }
}
