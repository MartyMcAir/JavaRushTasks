package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;

        // https://younglinux.info/algorithm/euclidean
        // Алгоритм Евклида - нахождение наибольшего общего делителя
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        // В случае если введенные строки невозможно преобразовать
        // в положительные целые числа, должно возникать исключение.
        if (n1 <= 0 || n2 <= 0) throw new Exception();

//        while (n1 != 0 & n2 != 0) {
//            if (n1 > n2) {
//                n1 = n1 % n2;
//            } else {
//                n2 = n2 % n1;
//            }
//        }
//        System.out.println(n1+n2);

        int a = n1;
        int b = n2;
        int c = a % b; // вычисляем остаток от деления a на b
        while (c != 0) { // пока остаток не будет равен 0
            a = b; // меняем местами b и остаток от деления c прошлой итерации
            b = c;
            c = a % b; // и находим новый остаток от деления
        }
        System.out.println(b);

//        try { // с try  - не принимает хотя и работает
//        ArrayList<Integer> list = new ArrayList<Integer>();
//            int n1 = Integer.parseInt(reader.readLine());
//            int n2 = Integer.parseInt(reader.readLine());
//
//            int min = n1 < n2 ? n1 : n2; // находим найменьшее
//            int max = n1 > n2 ? n1 : n2; // находим найбольшее
//            while (true) {
//                if (count <= min) { // чтоб count не стал больше min
//                    if (((min % count) == 0) & ((max % count) == 0)) {
//                        // есди остаток от деления 0
//                        list.add(count); // добавляем делитель
//                    }
//                    count++;
//                } else {
//                    break;
//                }
//            }
//            System.out.println(list.get(list.size()-1));
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

    }
}
