package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
//        String file1 = arrF[0];
//        String file2 = arrF[1];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
//        String file2 = bf.readLine();
        bf.close();

        PrintStream prOrigin = System.out;
        ByteArrayOutputStream bt = new ByteArrayOutputStream();
        PrintStream prNew = new PrintStream(bt);
        System.setOut(prNew);
        testString.printSomething();
        System.setOut(prOrigin);

        String res = bt.toString();

        OutputStream out = new FileOutputStream(new File(file1));
        out.write(res.getBytes());
        out.close();
        System.out.println(res);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

