package com.javarush.task.task14.task1421;

/* 
Singleton
*/
public class Solution {
    public static void main(String[] args) {
//        Singleton sl = new Singleton(); // has private access
        Singleton sl = Singleton.getInstance(); // good access
    }
}
