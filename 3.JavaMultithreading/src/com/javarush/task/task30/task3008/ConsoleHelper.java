package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// В этой задаче и далее, если не указано дополнительно другого,
// то все поля класса должны быть приватными, а методы публичными.
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String res = null;
        try {
//            res = bufferedReader.readLine();
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }
//        return res;
    }

    public static int readInt() {
        int res = 0;
        try {
//            res = Integer.parseInt(readString());
            return Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readInt();
        }
//        return 0;
    }
}
