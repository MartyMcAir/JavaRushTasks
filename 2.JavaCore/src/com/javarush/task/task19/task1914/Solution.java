package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream prOrigin = System.out;
        ByteArrayOutputStream bt = new ByteArrayOutputStream();
        PrintStream prNew = new PrintStream(bt);
        System.setOut(prNew);

        testString.printSomething();
        System.setOut(prOrigin);

        String strRes = bt.toString();
        Pattern p = Pattern.compile("(?<first>([0-9])+) (?<mark>(\\S)+) (?<second>([0-9])+)"); // work
        Matcher m = p.matcher(strRes);
        String mark = null;
        int first = 0, second = 0, resInt = 0;
        while (m.find()) {
            first = Integer.parseInt(m.group("first"));
            second = Integer.parseInt(m.group("second"));
            mark = m.group("mark");
        }
        if (mark.equals("+")) {
            resInt = first + second;
        } else if (mark.equals("-")) {
            resInt = first - second;
        } else if (mark.equals("*")) {
            resInt = first * second;
        } else if (mark.equals("/")) {
            resInt = first / second;
        }

        System.out.println(first + " " + mark + " " + second + " = " + resInt);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

