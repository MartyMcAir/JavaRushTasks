package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp, DirectoryPath = "C:\\z_n\\new_test_folder\\";

        while (true) {   // т.е. запускаются нити, которые ищут в файлах пока юзер вводит остальные файлы
            tmp = bf.readLine();
//        String[] arrFile = new String[]{DirectoryPath + "data1.txt", DirectoryPath + "data2.txt", "exit"};
//        for (int i = 0; i < arrFile.length; i++) {
//            tmp = arrFile[i];

            if (tmp.equals("exit")) {
                break;
            }
            Thread th = new ReadThread(tmp);
            th.start();
            th.join();
        }
//        resultMap.forEach((k, v) -> System.out.println(k + " " + v));
        bf.close();
    }

    public static class ReadThread extends Thread {
        public static String fileName;

        public ReadThread(String fileName) throws IOException, InterruptedException {
            //implement constructor body
//            start(); // автозапуск нити
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                resultMap.put(fileName, fileReaderGetMaxRepeat(fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
        public int fileReaderGetMaxRepeat(String file) throws IOException {
            // data2 = 255, data1 = 121
            BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(file));

            HashMap<Integer, Integer> map = new HashMap<>();
            while (bfIn.available() > 0) {
                map.merge(bfIn.read(), 1, Integer::sum);
            }
//            map.forEach((k, v) -> System.out.println(k + " " + v));

            int res = Collections.max(map.values()), resultIs = 0;
            for (int item : map.keySet()) {
                if (map.get(item) == res) {
                    resultIs = item;
//                    System.out.println(item + " " + map.get(item));  // 32 12
                }
            }

            bfIn.close();
            return resultIs;
        }
//        public int fileReaderGetMaxByte(String file) throws IOException {
//            // data2 = 255, data1 = 121
//            BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(file));
//            int maxByte = Integer.MIN_VALUE, tmp;
//            while (bfIn.available() > 0) {
//                tmp = bfIn.read();
//                if (tmp > maxByte) {
//                    maxByte = tmp;
//                }
//            }
//            bfIn.close();
//            return maxByte;
//        }
    }
}
