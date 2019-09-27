package com.javarush.task.task01.task0134;

/* 
Набираем воду в бассейн
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getVolume(25, 5, 2));
    }

    public static long getVolume(int a, int b, int c) {
        // длина ширина глубина
        long res=a*b*c; // метры кубические_ формула для прямугольного бассейна
        // Овальный бассейн:  длина*ширина*глубина*0,89=Х м3
        // Прямоугольный бассейн: длина*ширина*глубина=Х м3
        return res*1000; // литры на выходе
    }
}