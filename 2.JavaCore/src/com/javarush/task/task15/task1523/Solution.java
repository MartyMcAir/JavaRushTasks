package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public Solution(String s) { }

    private Solution(String s, int n) { }

    protected Solution(String s, int n, int n2) { }

    Solution() { }

    public static void main(String[] args) {

    }
}

