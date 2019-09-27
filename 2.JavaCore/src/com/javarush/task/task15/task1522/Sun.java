package com.javarush.task.task15.task1522;

public final class Sun implements Planet{ // final запрещаем наследование
    // объявляем переменную без инициализации (ведь поля а тем более static первыми идут),
    // а значит для ленивой загрузки, т.е. создаваться будет экземпляр по требованию через метод
    private static Sun instance = null;

    // вариант не учистывает многопоточность, множество JVM, и ряд др нюансов

    private Sun() {
    } // запрещаем создание экземпляра класса на прямую через конструктор

    public static Sun getInstance() {
        if (instance == null) { // условие if для предотващени повторного создания экземпляра класса
            instance = new Sun();
        }
        return instance;
    }
}
