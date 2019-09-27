package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getMultiply(1,2,3,4,5,6,7,8,9,10));
    }

    public static int getMultiply(int...a){
        int result=0, res=0;
        for(int item : a){
            res = item;

            result *= res;
        }
        return result;
    }
}
