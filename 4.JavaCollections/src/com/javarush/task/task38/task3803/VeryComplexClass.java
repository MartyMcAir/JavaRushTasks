package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = "str";
        Byte b = (byte) obj;
    }

    public void methodThrowsNullPointerException() {
        Integer intNum = null;
        intNum.intValue();

    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
//        veryComplexClass.methodThrowsClassCastException();
//        veryComplexClass.methodThrowsNullPointerException();
    }
}
