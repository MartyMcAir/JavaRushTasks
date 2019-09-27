package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import javax.xml.stream.events.Characters;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrPath = new String[]{dir + "data.txt", dir + "dataRes.txt",
                dir + "dataEncrypt.txt", "end"};
//        String fileName = arrPath[0], fileNameOut = arrPath[1];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
        bf.close();

        if (args.length != 0) {
            String idNeed = args[1], args0 = args[0], tmpLine = null;
//            String idNeed = "19847983", args0 = args[0], tmpLine = null;

            // Читаем файл и сохраняем содержимое в список _ и сразу же при чтении
            // исщем искомую строку с нужным id и сохраняем номер этой строки
            BufferedReader bfR = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileName)
//                    , Charset.forName("cp1251")
            ));
            ArrayList<String> list = new ArrayList<>();

            int indexIs = 0;
            for (int i = 0; (tmpLine = bfR.readLine()) != null; i++) {
                if (tmpLine.substring(0, 8).trim().equals(idNeed)) {
                    indexIs = i; // искомый индекс для удаляния или обновления
                }
                list.add(tmpLine);
            }
            bfR.close();

//            list.forEach(v -> System.out.print(v));
            // перебираем вариантивность в зависимости от поступившей команды -c или -u
            if (args[0].trim().equals("-u")) { // -u 12345678 Шортыпляжныесиние 150.00 1235
                String id = spaceCounter(args[1], 8);
                String product = spaceCounter(args[2], 30);
                String price = spaceCounter(args[3], 8);
                String quantity = spaceCounter(args[4], 4);
                String element = id + product + price + quantity;
//                String element = idNeed + args[2] + args[3] + args[4];
                list.set(indexIs, element);
            } else if (args[0].trim().equals("-d")) {
                list.remove(indexIs);
            }
//            System.out.println("\n____\n");
//            list.forEach(v -> System.out.print(v));

            // Записываем измененный список (после операции -u или -d _ false т.е. перезапишем файл
            BufferedWriter bfWr = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName, true)
//                    , Charset.forName("cp1251")
            ));
            for (String item : list) {
                bfWr.write(item);
                bfWr.newLine();
            }
            bfWr.close();
        }
    }

    public static String spaceCounter(String original, int number) {
        while (original.length() < number) {
            original += " ";
        }
        return original;
    }
}
