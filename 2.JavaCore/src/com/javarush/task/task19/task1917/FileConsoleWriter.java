package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

//public class FileConsoleWriter extends FileWriter {
public class FileConsoleWriter {
    public static void main(String[] args) throws IOException {
        FileConsoleWriter fcw = new FileConsoleWriter(new File(myPath()[2]));
        fcw.write(new char[]{'q', 'w', 'e', 'r', 't', 'y'});
        fcw.write("\r\n");
        fcw.write("NewString");
        fcw.write("\r\n");
        fcw.write(2_000_000_000);
        fcw.write("\r\n");
        fcw.write(new char[]{'q', 'w', 'e', 'r', 't', 'y', '1', '2', '3'}, 2, 4);
        fcw.write("\r\n");
        fcw.write("Qwerty123!", 2, 4);
        fcw.write("abcdefghijklmnop", 3, 5);


        fcw.close();

    }

    private FileWriter fileWriter;

    FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }

    FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    // len символов из строки str, начиная с индекса off;
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
//        System.out.print(str);
//        System.out.print(str.substring(off, str.length() + len)); // ---
//        System.out.print(str.substring(off, str.length() - len));
        System.out.print(str.substring(off, off + len)); // right!
    }

    // записывает данные в поток, len байт из массива b, начиная с индекса off
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
//        System.out.println(cbuf.toString() + off + len);
        System.out.print(new String(cbuf, off, len)); // copy past
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(cbuf);
    }


    public void write(int c) throws IOException {
//        fileWriter.write(c+"");
        fileWriter.write(c);
        System.out.print(c + "");
//        System.out.print((int) c);
//        System.out.print((char) c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }


    public void close() throws IOException {
        fileWriter.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file_1.txt", dir
                + "file_2.txt", dir
                + "file3.txt"};
    }

}
