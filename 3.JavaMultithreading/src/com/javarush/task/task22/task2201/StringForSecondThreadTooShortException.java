package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(String msg, Throwable cause) {
        super(msg, cause);
    }
//
//    public StringForSecondThreadTooShortException(String msg) {
//        super(msg);
//    }
    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("String index out of range: -1");
    }
}
