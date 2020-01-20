package com.javarush.task.task24.task2411;

public class C implements JustAnInterface {
//public class C {
    public C() {
        System.out.print("C");
        B localB = B; // без этой строки вывод: CAYS
    }
}