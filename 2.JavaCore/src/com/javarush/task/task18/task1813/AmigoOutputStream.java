package com.javarush.task.task18.task1813;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream original;
//    public AmigoOutputStream(FileOutputStream component) {
//        this.original = component; }
//    protected void finalize() { // finalize()' has protected access in 'java.io.FileOutputStream
//        original.finalize();  }

    public AmigoOutputStream(FileOutputStream fileN) throws FileNotFoundException {
        super(fileName);
//        super(fileName);
        this.original = fileN;
    }

    @Override
    public void close() throws IOException {
        original.flush();
        write("JavaRush © All rights reserved.".getBytes());
        original.close();
//        clone(); // only with try catch
    }

    public void flush() throws IOException {
        original.flush();
    }

    public FileChannel getChannel() {
        return original.getChannel();
    }

    public FileDescriptor getFd() throws IOException {
        return original.getFD();
    }

    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    public void write(int b) throws IOException {
        original.write(b);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
