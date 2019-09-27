package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line1 = bf.readLine();
        String line2 = bf.readLine();

//        Path pAll = Paths.get("C:\\z_n\\new_test_folder\\", "file_name.txt");
//        Path pRem = Paths.get("C:\\z_n\\new_test_folder\\", "file_name2.txt");

        try {
//            readFile(pAll.toString(), "allLines");
            readFile(line1, "allLines");
            readFile(line2, "forRemoveLines");
            new Solution().joinData();
        } catch (FileNotFoundException e) { // обработка искл от более специализированного к общему
            e.printStackTrace();
        } catch (CorruptedDataException e) {
//            System.out.println("zzz _ it is Work");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bf.close();
        }

//        System.out.println("allLines above: " + allLines.toString()); // work
//        System.out.println("forRemoveLines: " + forRemoveLines.toString()); // work
//        System.out.println(allLines.toString().equals(forRemoveLines.toString())); // true
//        System.out.println(allLines.containsAll(forRemoveLines)); // true _
//        System.out.println("allLines afther: " + allLines.toString()); // work
    }

    public void joinData() throws CorruptedDataException {
        // если список allLines содержит все строки из forRemoveLines
        if (allLines.containsAll(forRemoveLines)) {
            int index;
            for (String item : forRemoveLines) {
                index = allLines.indexOf(item);
                if (index != -1) {  // если не содержит данную строку, то !=-1 и удалить елем по индексу
                    allLines.remove(index);
                }
            }
        } else if (!allLines.containsAll(forRemoveLines)) {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    //  Все исключения обработайте в методе main. так что пробрасываем на верх throws
    public static void readFile(String path, String listName) throws FileNotFoundException, IOException {
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String tmp;
        while (bf.ready()) {
            tmp = bf.readLine();
            if (listName.equals("allLines")) {
                allLines.add(tmp);
            } else if (listName.equals("forRemoveLines")) {
                forRemoveLines.add(tmp);
            }
        }
        bf.close();
    }
}
