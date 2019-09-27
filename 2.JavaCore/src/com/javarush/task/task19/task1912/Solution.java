package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream prOrigin = System.out;
        ByteArrayOutputStream btOut = new ByteArrayOutputStream();
        PrintStream prNew = new PrintStream(btOut);
        System.setOut(prNew);

        testString.printSomething();

        System.setOut(prOrigin);

        String res = btOut.toString().replaceAll("te", "??");
        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
