package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/*
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
//        BufferedReader bfrd = null;
//        BufferedWriter bfwr = null;
        String tmp, pathTxt = "C:\\z_n\\new_test_folder\\file_name.txt";

        // Write
        //    if(!fp.exists()){
        //	            fp.createNewFile();
        //	        }
        // File fp = new File("C:\\z_n\\new_test_folder\\1\\2\\charBufWr2.txt");
        // BufferedWriter bufWr = Files.newBufferedWriter(fp.toPath(),
        //	                            Charset.forName("cp1251"),
        //                            StandardOpenOption.APPEND);

        // Or _ Write
        // OutputStream out = new FileOutputStream("C:\\book\\test.txt");
        //		Writer writer = new OutputStreamWriter(out, "cp1251");
        // BufferedWriter buf = new BufferedWriter(writer);

        // Or
        // FileWriter file=new FileWriter("C:\\z_n\\oscar2.txt");
        // BufferedWriter buffer = new BufferedWriter(file);

        // Or
        // BufferedWriter buf = Files.newBufferedWriter(
        // Paths.get("C:\\book\\utf8.txt"), Charset.forName("utf-8"), StandardOpenOption.APPEND);

        try {

            BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));

            File file = new File(bfrd.readLine());
            FileWriter fileReader = new FileWriter(file);
            BufferedWriter bfwr =  new BufferedWriter(fileReader);
//            BufferedWriter bfwr = Files.newBufferedWriter(Paths.get(bfrd.readLine()), Charset.forName("utf-8"), StandardOpenOption.WRITE);
//            bfwr = Files.newBufferedWriter(Paths.get(pathTxt), Charset.forName("utf-8"), StandardOpenOption.WRITE);
            while (true) {
                tmp = bfrd.readLine();

                if (tmp.toLowerCase().trim().equals("exit")) {
//                    bfwr.newLine();
                    bfwr.write(tmp + "\n"); // + "\n"
                    break;
                } else {
//                    bfwr.newLine();
                    bfwr.write(tmp + "\n");
                }
            }

            bfwr.close();
            bfrd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
