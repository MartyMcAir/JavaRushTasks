package com.javarush.task.task08.task0819;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {

    public static Cat cat1 = new Cat();
    public static Cat cat2 = new Cat();
    public static Cat cat3 = new Cat();

    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
//        cats.remove(cat3);
        cats.remove(cats.iterator().next());
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> cats = new HashSet<Cat>();
//        Collections.addAll(cats, new Cat(), new Cat(), new Cat());
        Collections.addAll(cats, cat1, cat2);
        cats.add(cat3);
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        cats.forEach((cat) -> System.out.println(cat.toString()));
//        for(Cat item : cats){
//            System.out.println(item);
//        }
//        Iterator it = cats.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
    }

    // step 1 - пункт 1
    public static class Cat {

    }
}
