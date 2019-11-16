package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream prOrigin = System.out;
        ByteArrayOutputStream bt = new ByteArrayOutputStream();
        PrintStream prNew = new PrintStream(bt);
        System.setOut(prNew);

        testString.printSomething();
        System.setOut(prOrigin);

        String[] arrSt = bt.toString().split(System.lineSeparator());
        for (int i = 0; i < arrSt.length; i++) {
            System.out.println(arrSt[i]);
            if ((i - 1) % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

//        BufferedReader bf = new BufferedReader(new InputStreamReader(
//                new ByteArrayInputStream(bt.toString().getBytes())));
//        int i = 0;
//        while (bf.ready()) {
//            i++;
//            System.out.println(bf.readLine());
//            if ((i % 2) == 0) {
//                System.out.println("JavaRush - курсы Java онлайн");
//            }
//        }
//        bf.close();

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

}
