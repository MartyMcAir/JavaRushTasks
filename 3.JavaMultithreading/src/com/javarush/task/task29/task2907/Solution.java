package com.javarush.task.task29.task2907;

import java.math.BigDecimal;

/* 
Этот странный BigDecimal
*/
// https://javarush.ru/tasks/com.javarush.task.task29.task2907#discussion
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        // 2.3000000000000000444089209850062616169452667236328125
//        return new BigDecimal(v1).add(new BigDecimal(v2));
        // 2.3
//        return BigDecimal.valueOf(v1).add(BigDecimal.valueOf(v2));
        return new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2)));
    }
}

// При использовании конструктора, принимающего на вход double, возникает неприятная особенность, отмеченная в документации.
//Поскольку вещественное число при переводе в двоичную форму представляется, как правило, бесконечной двоичной дробью, то при создании объекта, например, BigDecimal(0.1), мантисса, хранящаяся в объекте, окажется очень большой. (ссылка на статью)
//Поэтому число будет сохранено неточно. В связи с этим лучше используйте конструктор, принимающий на вход строку:
//Bigdecimal bet = new Bigdecimal("0.00000010");