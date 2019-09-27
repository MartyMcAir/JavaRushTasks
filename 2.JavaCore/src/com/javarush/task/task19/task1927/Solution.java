package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream prOrigin = System.out;
        ByteArrayOutputStream bt = new ByteArrayOutputStream();
        PrintStream prNew = new PrintStream(bt);
        System.setOut(prNew);

        testString.printSomething();
        System.setOut(prOrigin);

        String[] arrSt = bt.toString().trim().split("[\\n]");
        System.out.println(arrSt.length);
        for (int i = 0, j = 0; i < arrSt.length; i++) {
            if (j < 2) {
                System.out.println(arrSt[i]);
                j++;
            } else {
                j = 0;
                System.out.println("JavaRush - курсы Java онлайн");
                j++;
                System.out.println(arrSt[i]);
            }
        }
//        System.out.println(bt.toString());    if (Character.isAlphabetic((char) tmpInt))

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

//    public static class ByteArr extends ByteArrayOutputStream {
//
//    }

//    public static class ReaderWrap extends PrintStream {
//
//    }
}
