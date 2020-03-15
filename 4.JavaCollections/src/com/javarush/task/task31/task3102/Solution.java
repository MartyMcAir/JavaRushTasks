package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                list.add(file.toAbsolutePath().toString());
                return FileVisitResult.CONTINUE;
            }

        });
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileTree = getFileTree("c:\\z_n\\new_test_folder\\12_05_19\\");
        fileTree.forEach(v -> System.out.println(v + " _ "));
    }


}
