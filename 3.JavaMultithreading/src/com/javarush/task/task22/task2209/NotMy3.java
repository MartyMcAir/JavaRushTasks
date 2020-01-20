package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tmp4 {

    private ArrayList<String> stroka = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String fileName = getPath()[2];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")));
        String txt;
        String stroka = "";
        while ((txt = fr.readLine()) != null) {
            stroka += txt + " ";
        }
        reader.close();
        fr.close();
        String[] words = stroka.split(" ");
        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) throws IOException {
        //----------------- Добавляю СБ
        StringBuilder sb = new StringBuilder();
        //----------------- Если массив больше нуля, то делаем, если нет, то возвращаю пустой СБ
        if (words.length > 0) {
            //------------- Строки первоеСлово и второеСлово , они нужны будут в цикле дальше
            String firstWord;
            String secondWord;
            //-----------------Массивы символо для первого и второго слова , нужны будут для цикла дальше
            char[] first;
            char[] second;
            // Set<String> set = new HashSet<>();
            //-------------- Добавляю Слова в Список
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                list.add(words[i]);
            }
//---------------------------Сортирую список
            Collections.sort(list);
            //--------------- Список отсортирован в алфавитном порядке ,поэтому добавляю первый элемент в СБ
            sb.append(list.get(0));
            //---------------первоеСлово соответствует первому элементу
            firstWord = list.get(0);
            //--------------- начинаю цикл перебора слова
            for (int i = 0; i < list.size(); i++) {
                //------------ Разьиваем первоеСлово на массив символов
                first = firstWord.toCharArray();
                //------------второеСлово присваивает знаение элементы из списка соответствующий номеру i
                secondWord = list.get(i);
                //------------ Разьиваем второеСлово на массив символов
                second = secondWord.toCharArray();
                //------------ Если последний символ первого слова эквивалентен первому символу второго слова то:
                if (String.valueOf(first[first.length - 1]).equalsIgnoreCase(String.valueOf(second[0]))) {
                    //-------- Добавить его в СБ
                    sb.append(" " + secondWord);
                    //-------- Присвоить значение второгоСлова первомуСлову
                    firstWord = secondWord;
                    //--------Удалить этот элемент из списка
                    list.remove(i);
                    //--------Обнулить цикл
                    i = 0;
                }
            }
            return sb;
        } else {
            return sb;
        }
    }

    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\1\\";
        return new String[]{folder + "data.txt", folder + "data2.txt", folder + "dataLite.txt"};
    }
}
