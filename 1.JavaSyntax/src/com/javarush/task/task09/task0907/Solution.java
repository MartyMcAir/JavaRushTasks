package com.javarush.task.task09.task0907;

/* 
Исключение при работе с числами
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try {
            int a = 42 / 0;
        } catch(ArithmeticException e) { // ArithmeticException e _ Exception e
            //напишите тут ваш код
            //   System.out.println("Division by zero. Exception has been caught");
//            System.out.println(e.fillInStackTrace());  // java.lang.ArithmeticException: / by zero
//            System.out.println(e);  // java.lang.ArithmeticException: / by zero
//            System.out.println(e.toString());  // java.lang.ArithmeticException: / by zero
//            System.err.println(e.getClass().getSimpleName()); // ArithmeticException - не проходит
            System.out.println(e.getClass().getSimpleName()); // ArithmeticException

//            System.out.println(e.getMessage()); // / by zero
//            System.out.println(e.getLocalizedMessage()); // / by zero
//            System.out.println(e.getCause()); // null
        }
    }
}
