package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.concurrent.TimeoutException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends ArithmeticException {

    }

    static class MyException2 extends IndexOutOfBoundsException{
    }

    static class MyException3 extends TimeoutException {
    }

    static class MyException4 extends TimeoutException{
    }
}

