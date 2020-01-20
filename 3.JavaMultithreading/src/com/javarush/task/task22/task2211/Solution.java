package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = getPath()[0];
        String fileName2 = getPath()[1];

        String param1 = args[0];
        String param2FileName = args[1];

        InputStream in = new FileInputStream(new File(param1));
        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        in.close();
        String s = new String(buffer, Charset.forName("windows-1251"));
//        System.out.println(Charset.availableCharsets());

        OutputStream out = new FileOutputStream(new File(param2FileName));
        buffer = s.getBytes(Charset.forName("UTF-8"));
        out.write(buffer);
        out.close();


//        BufferedReader fileReader = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")));
//        fileReader.close();
//
//        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, Charset.forName("UTF-8")));
//        fileWriter.close();

    }

    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\1\\";
        return new String[]{folder + "code_dataCP1251.txt", folder + "code_dataUTF8.txt", folder + "dataLite.txt"};
    }
}
