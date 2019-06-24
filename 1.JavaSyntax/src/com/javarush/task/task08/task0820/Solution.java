package com.javarush.task.task08.task0820;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

//        System.out.println(" ___ ");
        removeCats(pets, cats);
        printPets(pets);

        ///////////
//        Set<Object> pets2 = join(createCats(), createDogs());

        // stepbystep.TestForT$Cat@48140564, stepbystep.TestForT$Cat@49e4cb85,
        // stepbystep.TestForT$Cat@7c30a502, stepbystep.TestForT$Cat@58ceff1,
//        createCats().forEach((catss)->System.out.print(catss+", "));
//        System.out.println("pets2: "+pets2.toString());
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        //напишите тут ваш код
        Collections.addAll(result, new Cat(), new Cat(), new Cat(), new Cat());
        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        Set<Dog> res = new HashSet<Dog>();
        Collections.addAll(res, new Dog(), new Dog(), new Dog());
        return res;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        Set<Object> res = new HashSet<Object>();
        Iterator<Dog> itDog = dogs.iterator();

        cats.forEach((obj) -> res.add(obj));

//        for(Cat it : cats){
//            res.add(it);
//        }
        while (itDog.hasNext()) {
            res.add(itDog.next());
        }

        return res;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        // должен удалять из множества pets всех котов, которые есть в множестве cats.

        //cats :
        // TestForT$Cat@48140564, TestForT$Cat@49e4cb85,
        // TestForT$Cat@7c30a502, TestForT$Cat@58ceff1,
        for(Cat it : cats){
            if(pets.contains(it)){ // удаляет
                pets.remove(it);
            }
        }

//        for(Cat it : cats){
////            if(pets.equals(it)){ // не удаляет
//            if(pets.hashCode()==it.hashCode()){ // не удаляет
//                pets.remove(it);
//            }
//        }

    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        pets.forEach((obj)->System.out.println(obj));
    }

    //напишите тут ваш код
    public static class Cat {

    }

    public static class Dog {

    }
}
