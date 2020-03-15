package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);
        System.out.println("---------------------------------");

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);
        System.out.println("---------------------------------");

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws IOException {
        if (!Files.notExists(Paths.get(fileName))) {
            Properties properties = new Properties();
            FileInputStream inStream = new FileInputStream(fileName);
            if (fileName.endsWith("xml")) {
                properties.loadFromXML(inStream);
            } else {
                properties.load(inStream);
            }
            return properties;
        }
        return new Properties();
    }

    private static void splitFileToZip(String filePath, String pathForOut, int bufferSize) throws IOException {
        if (bufferSize == 0)
            bufferSize = (1024 * 1024) * 2;

        try (BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] bytes = new byte[bufferSize];
            DecimalFormat decimalFormat = new DecimalFormat("000"); // для форматирования Parts

            for (int amountOfBytes = -1, counter = 1; (amountOfBytes = bfIn.read(bytes)) != -1; counter++) {
                String numberOfPart = decimalFormat.format(counter);   // 001.. 002..
                Path fileName = Paths.get(filePath).getFileName();
                String pathForNewPart = pathForOut + fileName + ".zip." + numberOfPart; // имя для след части zip.00*

                try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(pathForNewPart))) {
                    zipOut.putNextEntry(new ZipEntry(fileName.toString()));
                    zipOut.write(bytes);
                }
            }
        }
    }

}
