package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();
//        String string = "строка подстрока";
//        String substring = "подстрока";

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
//        boolean found = false;
//        int max = string.length() - substring.length();
//
//        for (int i = 0; i <= max; i++) {
//            int countOfMatches = 0;
//            int length = substring.length();
//            int j = i;
//            int k = 0;
//            while (length-- != 0) {
//                if (string.charAt(j++) != substring.charAt(k++)) {
//                    found = false;
//                    length = 0;
//                } else {
//                    found = true;
//                    countOfMatches++;
//                }
//
//                if (countOfMatches == substring.length()) {
//                    i = max + 1;
//                }
//            }
//        }
//        return found;
        // Genious! _ Funny..
        return string.contains(substring);
    }

    // работает но не проходит
    static boolean isSubstringPresentMyWork(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length(); // разница длины строк
        label:
        for (int i = 0; i <= max; i++) {
            int length = substring.length();
            int j = i;
            int k = 0;
            // после первого совпадения length сдвигается до конца потом идет к found = true;
            // k  и j - инкрементируются одновоременно тем самым двигаются
            // к след символу для их сравнения
            found = true;
            while (length-- != 0) { // пока строка не закончилась т.е. не = 0
                // если символы не совпадают, то главн уикл начин заново
                if (string.charAt(j++) != substring.charAt(k++)) {
// ccccccc
                    found = false;
                }
            }
// bbbbbbb
        }
        return found;
    }

    static boolean isSubstringPresentOrigin(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length(); // разница длины строк
        label:
        for (int i = 0; i <= max; i++) {
            int length = substring.length();
            int j = i;
            int k = 0;
            // после первого совпадения length сдвигается до конца потом идет к found = true;
            // k  и j - инкрементируются одновоременно тем самым двигаются
            // к след символу для их сравнения
            while (length-- != 0) { // пока строка не закончилась т.е. не = 0
                // если символы не совпадают, то главн уикл начин заново
                if (string.charAt(j++) != substring.charAt(k++)) {
                    continue label;
                }
            }
            found = true;
            break label;
        }
        return found;
    }
}

