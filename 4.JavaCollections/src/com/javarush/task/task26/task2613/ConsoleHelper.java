package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static String readString() {
        String res = "";
        try {
            res = bis.readLine();
        } catch (IOException ignored) {
        }
        return res;
    }


    public static String askCurrencyCode() {
        writeMessage("Введите код валюты 3 символа: ");
        String currencyCode = readString();
        while (currencyCode.length() != 3) {
            writeMessage("Ввод неверный, попробуйте снова");
            writeMessage("Введите код валюты (3 символа): ");
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }

    public static String askCurrencyCodeMY() {
        writeMessage("Entry your currency code: ");
        boolean flag = false, validate = false;
        String s = "";

        do {
            if (flag) writeMessage("Your currency code is incorrect, please entry again: ");
            if (!flag) flag = true;
            s = readString();

            if (s.length() == 3 & s.matches("[a-zA-Z]{3}")) {
                validate = true;
            }
        } while (!validate);

        return s;
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        boolean flag = false, validate = false;
        String[] arrStr = new String[2];

        do {
            if (flag) writeMessage("Your data is incorrect, please entry again: ");
            if (!flag) flag = true;
            writeMessage("Entry your number for nominal and bucks: ");
            String[] arrS = readString().split(" ");

            // если значние не было разделено пробелом то переход к след интерации во избежание ArrayIndexOutOfBoundsException
            if (arrS.length != 2) continue;

            if (arrS.length == 2 & arrS[0].matches("[0-9]{1,9}") & arrS[1].matches("[0-9]{1,9}")) {
                validate = true;
                arrStr = arrS;
            }
        } while (!validate);
        return arrStr;
    }

}