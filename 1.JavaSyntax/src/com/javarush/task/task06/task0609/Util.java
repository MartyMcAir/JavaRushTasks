package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        // x1 и y1 - это первая точка на чертеже
        // x2 и y2 - это вторая точка на чертеже
//        Math.pow() // Возвращает значение первого аргумента, возведенное в степень второго
//        т.е. первый аргумент умноженный сам на себя n раз (т.е. столько сколько указано в 2ом аргументе)

//        Math.hypot​(double x, double y) return without intermediate overflow or underflow.
//        Возвращает длину гипотенузы т.е. первый и второй аргументы возводит в
//        квадратный корень и плюсует их

//        Math.sqrt(double a) - Возвращает квадратный корень аргумента.
        // понятие квадратный корень подразумевается, что искомое число,
        // это число возведенное в вторую степень (т.е. умноженное дважды само на себя)
        // даёт в сумме т.е. в результате число из которого и нужен корень
        // т.е. 7*7=49 значит корень 49ти это 7

        double step1 = x1 - x2; // 7.0 or (x2-x1)= -7.0
        double step2 = y1 - y2; // -1.0 or (y2-y1)= 1.0
//        double step4 = Math.hypot(step1, step2); // 7.0710678118654755 - right!

//        return = Math.sqrt((step1 * step2) + (step2 * step1)); // NaN return
        // Math.sqrt(x) returns NaN when x is negative, which then propagates through
        // the rest of your code. You'll want to test for negative numbers before
        // taking the square root:

//        return Math.sqrt((x2-x1)*2+(y2-y1)*2); // 3.4 - wrong

        double step1_ = x2 - x1; // 7.0
        double step1_1 = step1_*step1_; // 49 = 7*7
        double alternative1_1 = Math.pow(step1_, 2); // 49
        double step2_ = y2 - y1; // -1.0
        double step2_1 = step2 * step2; // 1.0
        double alternative2_1 = Math.pow(step2_, 2); // 1.0
        double step3_1 = step1_1 + step2_1; // 50
        return Math.sqrt(step3_1); // 7.0710678118654755 - right!
//        double wrong_1 = Math.sqrt(step1_); // 7=2.6457513110645907

//        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)) * 1.0; // 7.0710678118654755 - right!!!
    }

    public static void main(String[] args) {
//        double res = Util.getDistance(-1, 3, 6, 2);
//        System.out.println(res);
    }
}
