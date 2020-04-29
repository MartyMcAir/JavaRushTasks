package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static void main(String[] args) {
        Class factoryClass = Solution.getFactoryClass();

    }

    public static Class getFactoryClass() {
        return new FactoryException().getClass();
    }
}