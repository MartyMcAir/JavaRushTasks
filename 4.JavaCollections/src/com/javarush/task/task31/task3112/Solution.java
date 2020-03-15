package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/* 
Загрузчик файлов
*/
// https://javarush.ru/tasks/com.javarush.task.task31.task3112#discussion
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }

    }

    public static Path downloadFileFromGitNeo(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Path tmp = Files.createTempFile("temp-", "tmp");
        Files.copy(url.openStream(), tmp, StandardCopyOption.REPLACE_EXISTING);
        Path result = Paths.get(downloadDirectory.toString(), urlString.substring(urlString.lastIndexOf("/")));
        Files.move(tmp, result);
        return result;
    }

    // my V1
    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        // Имя сохраненного файла должно быть таким же, как в URL-ссылке.
        // https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
        int index = urlString.lastIndexOf("/");   // 43
        String fileNameStr = urlString.substring(index + 1, urlString.length());   // yandex19-logo-ru.png

        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
//        Files.copy(inputStream, downloadDirectory);

        // Выкачивай сначала во временную директорию,
        // чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
        Path tempFile = Files.createTempFile("tmp", "_file_");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        // Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
        // должен переместить файл из временной директории в пользовательскую
        String separator = System.lineSeparator();
//        String strForNewPath = downloadDirectory.toString() + separator + fileNameStr;
        Path newPath = Paths.get(downloadDirectory.toString(), fileNameStr);
        Files.move(tempFile, newPath);

        return newPath;   // возвращаем путь к скачанному файлу _ т.е. место на диске куда его кинули
    }
}
