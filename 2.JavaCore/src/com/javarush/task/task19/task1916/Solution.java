package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        String file2 = bf.readLine();
        bf.close();

        ArrayList<String> f1 = new ArrayList<>();
        ArrayList<String> f2 = new ArrayList<>();
//        BufferedReader bfR1 = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedReader bfR1 = new BufferedReader(new FileReader(file1));
        while (bfR1.ready()) {
            f1.add(bfR1.readLine());
        }
        bfR1.close();

//        BufferedReader bfR2 = new BufferedReader(new FileReader(file2, Charset.forName("cp1251")));
        BufferedReader bfR2 = new BufferedReader(new FileReader(file2));
        while (bfR2.ready()) {
            f2.add(bfR2.readLine());
        }
        bfR2.close();

//        listOrigin.forEach(v -> System.out.print(v + " _ "));
//        System.out.println("");
//        listEdition.forEach(v -> System.out.print(v + " _ "));

        for (int i = 0; i < f1.size() && i < f2.size(); i++) {
            try {
                if (f1.get(i).equals(f2.get(i))) {
                    lines.add(new LineItem(Type.SAME, f2.get(i)));
                    f1.remove(i);
                    f2.remove(i);
                    i--;
                } else if (!f1.get(i).equals(f2.get(i)) && f2.size() > 1) {
                    if (!f1.get(i).equals(f2.get(i + 1))) {
                        lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                        f1.remove(i);
                        i--;
                    } else if (f1.get(i).equals(f2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, f2.get(i)));
                        f2.remove(i);
                        i--;
                    }
                } else {
                    lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                    f1.remove(i);
                    i--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                f1.remove(i);
                i--;
            }
        }

        while (!f1.isEmpty()) {
            lines.add(new LineItem(Type.REMOVED, f1.get(0)));
            f1.remove(0);
        }
        while (!f2.isEmpty()) {
            lines.add(new LineItem(Type.ADDED, f2.get(0)));
            f2.remove(0);
        }

//        lines.forEach(v -> System.out.println(v.toString()));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
