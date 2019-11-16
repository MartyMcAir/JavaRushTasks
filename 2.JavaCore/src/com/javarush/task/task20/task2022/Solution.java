package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;   // transient
    private String fileName; // code

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName; // code
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream
                (new FileOutputStream(myPath()[0])));
            // ругаеся на FileInputStream _ EOFException
             ObjectInputStream objIn = new ObjectInputStream(new BufferedInputStream(
                     new FileInputStream(myPath()[0])))) {
            Solution writeObject = new Solution(myPath()[0]);
            objOut.writeObject(writeObject);

            Solution loadedObj = new Solution(myPath()[1]);
            loadedObj.readObject(objIn);

            System.out.println(writeObject.equals(loadedObj));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }

}
