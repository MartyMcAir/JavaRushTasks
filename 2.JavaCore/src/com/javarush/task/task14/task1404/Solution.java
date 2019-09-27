package com.javarush.task.task14.task1404;

/* 
Коты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> list = new ArrayList<String>();
//        Collections.addAll(list, "vaska", "murka", "kiska");

        String tmp;
        ArrayList<Cat> listCat = new ArrayList<Cat>();
        while (true) {
            tmp = bf.readLine();
            if (tmp.equals("")) {
                break;
            } else {
//                listCat.add(tmp);
                listCat.add(CatFactory.getCatByKey(tmp));
            }
        }

//        Cat[] catsArr = listCat.toArray(new Cat[0]);

        for (int i = 0; i < listCat.size(); i++) {
//            Cat ccc = CatFactory.getCatByKey(list.get(i));
            Cat ccc = listCat.get(i);
            System.out.println(ccc);
        }
    }

    public static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
