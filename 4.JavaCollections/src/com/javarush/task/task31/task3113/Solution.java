package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
// https://javarush.ru/tasks/com.javarush.task.task31.task3113#discussion
public class Solution {
    private static int filesCounter = 0;
    private static int directoryCounter = 0;
    private static long commonSize = 0;

    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("c:\\z_n\\new_test_folder\\");

//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
        Path path = Paths.get(new Scanner(System.in).nextLine());

        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, new MyWalkOnTheTree());
            // ри подсчете количества папок, изначальную директорию считать не нужно.
            System.out.println("Всего папок - " + (directoryCounter - 1));
            System.out.println("Всего файлов - " + filesCounter);
            System.out.println("Общий размер - " + commonSize); // b
        } else {
            System.out.println(path.toString() + " - не папка");
        }
//        System.out.println("Общий размер - " + (commonSize / 1024)); // kb
//        System.out.println("Общий размер - " + ((commonSize / 1024) / 1024)); // mb
    }

    public static class MyWalkOnTheTree extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            byte[] bytes = Files.readAllBytes(file);
//            long size = Files.size(file);
            commonSize += attrs.size();
            filesCounter++;
            return super.visitFile(file, attrs);
        }

//        @Override   // тож подходит
//        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//            directoryCounter++;
//            return super.postVisitDirectory(dir, exc);
//        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            directoryCounter++;
            return super.preVisitDirectory(dir, attrs);
        }
    }
}
