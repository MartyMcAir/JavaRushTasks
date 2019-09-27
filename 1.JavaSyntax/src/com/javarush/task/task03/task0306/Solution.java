package com.javarush.task.task03.task0306;

/* 
Головоломка со скобками
*/

public class Solution {
    public static void main(String[] args) {
        //           382 = 2 *191=3+188=4*47=(5+42)
        System.out.println(2 * (3 + 4 * (5 + 6 * 7)));
    }
}
