package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
// https://javarush.ru/tasks/com.javarush.task.task32.task3202#discussion
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();

        try (BufferedInputStream bf = new BufferedInputStream(is)) {
            int n;
            while ((n = bf.read()) != -1) {
                writer.write(n);
            }
        } catch (Exception e) { // NullPointerException - валя не принял
            writer = new StringWriter();
        }
        return writer;
    }
}