package com.javarush.task.task06.task0614;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public static ArrayList<Cat> cats = new ArrayList<Cat>();
//    public static int catCount=0;
//    public static Cat[] arrCat = new Cat[10];

    public Cat() {
//        catCount++;
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 10; i++) {
//            arrCat[i]= new Cat();
            cats.add(new Cat());
        }
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        cats.forEach((n)-> System.out.println(n.toString())); // com.javarush.task.task06.task0614.Cat@30c7da1e
        // or
        for (int i = 0; i < 10; i++) {
//            System.out.println(arrCat[i]); // com.javarush.task.task06.task0614.Cat@30c7da1e

//            System.out.println(cats.get(i)); // com.javarush.task.task06.task0614.Cat@30c7da1e
//            System.out.println(cats.get(i).getClass()); // class com.javarush.task.task06.task0614.Cat
        }
        // or
//        Iterator<Cat> it = cats.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
    }
}
