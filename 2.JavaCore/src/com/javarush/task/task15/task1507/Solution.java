package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    // code _ 1
    public static void printMatrix(Integer m, Integer n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    // 2
    public static void printMatrix(int m, Integer n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    // 3
    public static void printMatrix(Integer m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    // 4
    public static void printMatrix(Integer n, String value, int m) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    // 5
    public static void printMatrix(String value, Integer n, int m) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    // 6
    public static void printMatrix(String value, int m, Integer n) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    // 7
    public static void printMatrix(int m, String value, Integer n) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    // 8
    public static void printMatrix(Integer m, String value, Integer n) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
}
