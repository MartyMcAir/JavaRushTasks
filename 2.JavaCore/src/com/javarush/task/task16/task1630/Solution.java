package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join(); // обеспечиваем последовательность
        //
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        public String fullFileName, content=""; // инициализируем content чтоб не было null при выводе

        @Override
        public void run() {
//            Path p = Paths.get("C:\\z_n\\new_test_folder\\", this.fullFileName+".txt");
            Path p = Paths.get(this.fullFileName);
            try (BufferedReader bf = Files.newBufferedReader(p, Charset.forName("cp1251"))) {
                String line;
                while ((line = bf.readLine()) != null) {
//                    content=bf.readLine();
                    this.content += line + " ";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return this.content;
        }

    }
}
