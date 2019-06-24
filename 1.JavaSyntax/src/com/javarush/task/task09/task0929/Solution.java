package com.javarush.task.task09.task0929;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // code
//        Path p = Paths.get(sourceFileName);
//        if (!Files.exists(p)) {
//            System.out.println("Файл не существует.");
//            sourceFileName = reader.readLine();
//        }
        // code
        InputStream fileInputStream = null;
        try {
            String sourceFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        } catch (IOException e) { // FileNotFoundException NoSuchFileException IOException
            System.out.println("Файл не существует.");
            String sourceFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        }

        String destinationFileName = reader.readLine();
        OutputStream fileOutputStream = getOutputStream(destinationFileName);
        // code

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

