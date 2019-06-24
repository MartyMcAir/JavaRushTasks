package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String str = "           Мама мыла     раму.               "; //bf.readLine();
        String str = bf.readLine();

        String[] sss = str.trim().split("[\\s]+");
        String nS = String.join(" ", sss);
//        System.out.println(nS); // Мама, мыла. раму

        ArrayList<Character> consonantsList = new ArrayList<Character>();
        ArrayList<Character> vowelsList = new ArrayList<Character>();

        char[] arrCh = nS.toCharArray();
        char tmp;
        for (int i = 0; i < arrCh.length; i++) {
            tmp = arrCh[i];
            if (isVowel(tmp)) {
                vowelsList.add(tmp);
            }
            if (Character.toString(tmp).equals(" ")) {
                continue;
            }
            if (!isVowel(tmp)) {
                consonantsList.add(tmp);
            }
        }

        vowelsList.forEach((v) -> System.out.print(v + " "));
        System.out.println();
        consonantsList.forEach((c) -> System.out.print(c + " "));
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}