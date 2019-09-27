package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner sc = new Scanner(System.in);
        InputStream in = null;
        String filePath;
        do {
            filePath = sc.nextLine();
            in = new FileInputStream(filePath);
            if (in.available() < 1000) {
                throw new DownloadException();
            }
        } while (in.available() >= 1000); // больше или равно 1000 байт не должно прекращать работу

        sc.close();
        in.close();
        
    }

    public static class DownloadException extends Exception {

    }
}
