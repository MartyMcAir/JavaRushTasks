package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String file1 = myPath()[0];
//        String file1 = args[0];

//        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedReader reader = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        while (reader.ready()) {
            String line = reader.readLine();
            String name = line.replaceAll("\\d", "").trim();
            String date = line.replace(name, "").trim();
            System.out.println(name);
            PEOPLE.add(new Person(name, sdf.parse(date)));
        }
        reader.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
    }
}
