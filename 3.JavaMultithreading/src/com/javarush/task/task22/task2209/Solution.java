package com.javarush.task.task22.task2209;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/*
Составить цепочку слов
*/
// https://javarush.ru/tasks/com.javarush.task.task22.task2209#discussion
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = getPath()[3];
        String[] words = null;
        try (BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader fileReader = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")))) {
             BufferedReader fileReader = new BufferedReader(new FileReader(inReader.readLine()))) {
            String content = fileReader.lines().collect(Collectors.joining(" "));
            words = content.split("\\s+");
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) {
            return sb;
        }
        if (words.length == 1) {
            sb.append(words[0]);
            return sb;
        }

        DirectedMultighraph graph = new DirectedMultighraph(words);
        List<String> trail = graph.findEulerianTrail();
        for (String word : trail) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(word);
        }

        return sb;
    }

    public static void myV1() {
        StringBuilder sb = new StringBuilder();
        String[] words = null;

        ArrayList<String> list = new ArrayList<>();
        for (String item : words) {
            list.add(item);
        }
        Collections.sort(list); // сортируем в алфавитном порядке
        // 'Киев Вена Амстердам Мельбурн Нью-Йорк'
        // без алфавитной сортировки будет:
        // 'Нью-Йорк Киев Вена Амстердам Мельбурн'

        ArrayList<Word> wordsList = new ArrayList<>();
        for (String item : list) {
            wordsList.add(new Word(item));
        }
        Collections.sort(wordsList);  // сортируем в соответствии с нашим Comparable

        for (int i = 0; i < wordsList.size() - 1; i++) {
            sb.append(wordsList.get(i).getWord() + " ");
        }
        sb.append(wordsList.get(wordsList.size() - 1));
    }

    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\zero\\";
        return new String[]{folder + "data.txt",
                folder + "data2.txt",
                folder + "dataLite.txt",
                folder + "example.txt",};
    }
}

