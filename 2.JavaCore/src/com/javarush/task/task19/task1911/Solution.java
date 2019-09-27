package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream btOut = new ByteArrayOutputStream();
        PrintStream prOrigin = System.out;

        PrintStream prNew = new PrintStream(btOut);
        System.setOut(prNew);
        testString.printSomething();

        //
        System.setOut(prOrigin);
        
        StringBuilder sb = new StringBuilder(btOut.toString());

        System.out.println(sb.toString().toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
