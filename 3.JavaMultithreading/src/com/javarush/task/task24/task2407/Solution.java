package com.javarush.task.task24.task2407;

import java.util.List;

/* 
Реализация интерфейса используя локальный класс
*/
public class Solution {
    public static void main(String[] args) {
        // Список наследников интерфейса Pet, классы Cat и Mouse
        List<Pet> pet = Util.getPets(); // возвращает заполненный список
        // toSayable - это метод интерфейса Pet - который возвращает Sayable
        // Дальше напоняет нов список уже pets
        List<Sayable> pets = Util.convertPetToSayable(pet);
        // принимает список <Sayable> и выводит их методы say в консоль
        Util.printDialog(pets);
    }
}
