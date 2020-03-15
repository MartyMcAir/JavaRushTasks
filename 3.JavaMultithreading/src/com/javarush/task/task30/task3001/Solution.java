package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
// https://github.com/Sukora-Stas/JavaRushTasks/blob/eb0371e1b363955ec113671816fb36a5ce1f73a0/3.JavaMultithreading/src/com/javarush/task/task30/task3001/Solution.java
// самы бы не решил, наверно..
// https://javarush.ru/tasks/com.javarush.task.task30.task3001#discussion
// http://streletzcoder.ru/perevod-sistem-schisleniya-s-pomoshhyu-klassa-biginteger-ili-kak-perevesti-chislo-v-druguyu-sistemu-schisleniya-s-pomoshhyu-odnoy-sroki-koda/
// Реализуй логику метода convertNumberToOtherNumberSystem, который должен переводить
// число number.getDigit(), из одной системы счисления (numberSystem) в другую (expectedNumberSystem).
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String str = bigInteger.toString(expectedNumberSystem.getNumberSystemIntValue());
        return new Number(expectedNumberSystem, str);
    }
}
