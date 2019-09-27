package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int n1 = 1;
        for(int i=0; i<10; i++){
            for(int j=1; j<11; j++){
                System.out.print((n1*j)+" ");
            }
            System.out.println();
            n1++;
        }
    }
}
