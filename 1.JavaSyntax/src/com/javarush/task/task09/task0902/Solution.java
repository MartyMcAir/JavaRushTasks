package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
//        System.out.println(method1());
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }


    public static String method2() {
        method3();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }


    public static String method3() {
        method4();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }


    public static String method4() {
        method5();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method5() {
        //напишите тут ваш код
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        String res = null;
        for (int i =0; i<st.length; i++) {
            if(i==2){
            res = st[i].getMethodName();
            }
        }
        return res;
    }
}
