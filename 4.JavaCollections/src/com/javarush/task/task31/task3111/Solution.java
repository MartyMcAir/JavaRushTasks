package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Продвинутый поиск файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        // Можно задавать либо один, либо сразу несколько критериев для поиска.
        searchFileVisitor.setPartOfName("amigo"); // встречающееся в названии файла
        searchFileVisitor.setPartOfContent("programmer"); // встречающееся в содержимом файла
        searchFileVisitor.setMinSize(500); // минимал размер файла
        searchFileVisitor.setMaxSize(10000); // максимал размер файла

        Files.walkFileTree(Paths.get("D:/SecretFolder"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
