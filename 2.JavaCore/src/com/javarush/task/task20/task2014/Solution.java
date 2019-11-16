package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        // CODE
        try {
            File file1 = new File(myPath()[0]);
//            if (!file1.exists()) {             file1.createNewFile();         }
            BufferedOutputStream bufOut = new BufferedOutputStream(new FileOutputStream(file1));
            ObjectOutputStream objOut = new ObjectOutputStream(bufOut);
            Solution savedObject = new Solution(33);
            objOut.writeObject(savedObject);
            objOut.flush();
            objOut.close();

            BufferedInputStream bufIn = new BufferedInputStream(new FileInputStream(file1));
            ObjectInputStream objIn = new ObjectInputStream(bufIn);
            Solution othObject = new Solution(66);

            Solution loadedObject = (Solution) objIn.readObject();
            objIn.close();

            System.out.println(savedObject.string.equals(loadedObject.string));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "newFile.txt", dir
                + "data_properties2.txt.properties", dir
                + "file3.txt"};
    }
}
