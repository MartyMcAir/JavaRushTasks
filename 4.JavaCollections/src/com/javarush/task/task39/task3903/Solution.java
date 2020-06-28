package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.LongBuffer;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/* 
Неравноценный обмен
*/
// https://javarush.ru/tasks/com.javarush.task.task39.task3903#discussion

//  означает что результ внутри метода свапаем 1ый и второй индекс значит: 1 1 0 0 0 ___ и на выходе это 24
// Ноо ответ верный другой..
//  ___ т.е. индексы подразумевается что они справа на лево выходит так!?
public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Please enter a number: ");
//
//        long number = Long.parseLong(reader.readLine());
//        System.out.println("Please enter the first index: ");
//        int i = Integer.parseInt(reader.readLine());
//        System.out.println("Please enter the second index: ");
//        int j = Integer.parseInt(reader.readLine());
//
//        System.out.println("The result of swapping bits is " + swapBits(number, i, j));

        // число 20  - (представление в битах) 1 0 1 0 0
        // после перестановы должно быть _1 1 0 0 0  _ ?
        System.out.println(swapBits(20, 1, 2));
    }
    // Этот методд дает правильны ответ в 18 на выходе
    public static long swapBits(long number, int i, int j) {
        if (i == j) return number;
        if (i > 63 || i < 0 || j > 63 || j < 0) throw new IllegalArgumentException();

        long firstBit = number & (1l << i);
        long secondBit = number & (1l << j);

        if (firstBit != 0) number |= 1l << j;
        else number &= ~(1l << j);

        if (secondBit != 0) number |= 1l << i;
        else number &= ~(1l << i);

//        System.out.println(Long.toBinaryString(number)); //
        return number;
    }
    // а этот метод неправильный
    // вроде как верно работает _ но сути задачи не понял у меня из 20тки на выходе 24 _ а  должно 18
    public static long swapBitsMy(long number, int i, int j) {
//        BitSet bitSet = new BitSet(); // подобие коллекции но для битов..
        String s = Long.toBinaryString(number);   // двоичное представление числа
        char[] chars = s.toCharArray();
        // переставляем индексы
        char char1 = chars[i];
        char char2 = chars[j];
        chars[i] = char2;
        chars[j] = char1;
        // возвращаем обратно в десятичной системе
        return Long.parseUnsignedLong(new String(chars), 2);  // 1100
    }
}
