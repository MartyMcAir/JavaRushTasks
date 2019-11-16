package com.javarush.task.task20.task2003;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bfR = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bfR.readLine();
//        String file1 = myPath()[0];

        FileInputStream fl = new FileInputStream(file1);
        load(fl);
        fl.close();
        bfR.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.save(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        prop.forEach((k, v) -> properties.put(k + "", v + ""));
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        s.fillInPropertiesMap(); // наполняем map

        String file1 = myPath()[1];
        FileOutputStream flOut = new FileOutputStream(file1);
        s.save(flOut); // записываем в файл map
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "data_properties.txt.properties", dir
                + "data_properties2.txt.properties", dir
                + "file3.txt"};
    }
}
