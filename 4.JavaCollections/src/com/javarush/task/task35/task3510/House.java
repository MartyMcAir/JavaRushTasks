package com.javarush.task.task35.task3510;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Iterator;
import java.util.List;

/*
Вход воспрещен!
*/
public class House<T> {
    private List<T> residents = new ArrayList<>();

    public static void main(String[] args) {
        Dog bruno = new Dog("Bruno");
        Puppy larsik = new Puppy("Larsik");
        Cat barsik = new Cat("Barsik");
        Kitten keksik = new Kitten("Keksik");

        House<Dog> dogHouse = new House<>();
//        House dogHouse = new House();
        dogHouse.enter(bruno);
        dogHouse.enter(larsik);
//        dogHouse.enter(barsik);
        System.out.println(dogHouse.toString());

        House<Cat> catHouse = new House<>();
//        House catHouse = new House();
        catHouse.enter(barsik);
        catHouse.enter(keksik);
//        catHouse.enter(bruno);
        System.out.println(catHouse.toString());
    }


    public void enter(T resident) {
//    public void enter(Object resident) {
        residents.add(resident);
//        checkConflicts();
    }

    public void leave(T resident) {
        residents.remove(resident);
    }

//    private void checkConflicts() {
//        boolean conflict = false; // перебирает список и если там найден объект Dog
//        for (Object resident : residents) {
//            if (resident instanceof Dog) {
//                conflict = true;
//            }
//        }
//
//        if (conflict) { // то удаляет все объекты Cat из очереди
//            Iterator iterator = residents.iterator();
//            while (iterator.hasNext()) { // удаляет через iterator, что не было ConcurrentException
//                Object resident = iterator.next();
//                if (resident instanceof Cat) {
//                    iterator.remove();
//                }
//            }
//        }
//    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("В доме находятся:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }

}
