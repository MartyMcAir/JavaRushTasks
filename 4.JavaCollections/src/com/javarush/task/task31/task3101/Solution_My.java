package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
Проход по дереву файлов
*/
public class Solution_My {
    private List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Solution_My sol = new Solution_My();
        String param_path = args[0];
        String param_resultFileAbsolutePath = args[1];
//        String param_path = "C:\\z_n\\new_test_folder";
//        String param_resultFileAbsolutePath = "C:\\z_n\\new_test_folder\\result.txt";

        File filePath = new File(param_resultFileAbsolutePath);

        String param_resultRename = "C:\\z_n\\new_test_folder\\allFilesContent.txt";

        File newFileName = new File(filePath.getParent() + File.separator + "allFilesContent.txt");
        if (FileUtils.isExist(filePath)) { //  Переименовать resultFileAbsolutePath в allFilesContent.txt
            FileUtils.renameFile(filePath, newFileName);
        }

        for (File item : Objects.requireNonNull(newFileName.getParentFile().listFiles())) {
            sol.prepareRecursivePath(item.toString()); // заполняем список путей ко всем файлам учитывая под папки
        }

        // Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
        Collections.sort(sol.list, (v1, v2) -> {
            File f1 = new File(v1);
            File f2 = new File(v2); // учитываем ток имя
            return f1.getName().compareTo(f2.getName());
        });

        // В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1.
        // После каждого тела файла записать "\n".
        List<byte[]> listBytes = new ArrayList<>();
        for (String item : sol.list) {
//            try (InputStream in = Files.newInputStream(Paths.get(item))) { //  try для AutoCloseable
//                    listBytes.add(in.readAllBytes()); // валя не пускает
            try (InputStream in = new FileInputStream(item)) {
                byte[] buf = new byte[in.available()];
                for (int i = 0; i < in.available(); i++) {
                    in.read(buf);
                }
                listBytes.add(buf);
            }
        }

        // валя ругается на try with resource
//        try (OutputStream out = Files.newOutputStream(newFileName.toPath())) {
        OutputStream out = null;
        try {
            out = Files.newOutputStream(newFileName.toPath());
            for (byte[] item : listBytes) {
                out.write(item);
                out.write("\n".getBytes());
            }
        } finally {
            out.close();
        }

    }

    public void prepareRecursivePath(String path) throws IOException {
        File file = new File(path);
        if (Files.isRegularFile(file.toPath())) {
            try (InputStream in = new FileInputStream(file)) {
                // Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
                if (in.available() < 50) {
                    list.add(path); // добавляем ток пути к файлу
                }
            }
// если файл то файл отправляется и опять вызывает в этом же методе этот же блок ветвления = StackOverFlowError
//            for (File item : file.getParentFile().listFiles()) {
//                recursivePath(item.toString());
//            }
        } else {
// если директория то директория отправляется и опять вызывает в этом же методе этот же блок ветвления
// = StackOverFlowError
//        for (File item : Objects.requireNonNull(newFileName.getParentFile().listFiles())) {
            for (File item : Objects.requireNonNull(file.listFiles())) { // а так всё норм
                prepareRecursivePath(item.toString());
            }
        }
    }
}
