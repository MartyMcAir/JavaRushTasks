package com.javarush.task.task33.task3310;

public class Tmp {
    // Shortener (1)
    //Давай напишем укорачиватель Shortener. Это будет некий аналог укорачивателя
    //ссылок Google URL Shortener (https://goo.gl), но мы расширим его функциональность и
    //сделаем консольным. Он будет сокращать не только ссылки, но и любые строки.
    //Наш Shortener - это класс, который может для любой строки вернуть некий
    //уникальный идентификатор и наоборот, по ранее полученному идентификатору
    //вернуть строку.

    // Shortener (2)
    //Укорачиватель Shortener будет поддерживать разные стратегии хранения данных (строк и их идентификаторов).
    // Все эти стратегии будут наследоваться от интерфейса StorageStrategy.
    // Наше хранилище будет оперировать двумя понятиями: ключ и значение.
    // Ключом будет идентификатор строки, а значением сама строка.

    // Shortener (3) _ 3.4. Реализуй метод getId, он должен: и getString _ там мы используем методы интерфейся
    // которые еще не реализовали,но уже используем _ т.е. пишем прогу сверзу вниз и юзаем не существующую логику
    // что бы еще раз осмотреть верность выбранногог подхода в архитектуре будущего ПО..

    // Shortener (4) _
    // String generateRandomString() {     // опять эта магия с система исчислений( _ сам бы не до пёр
    //        return new BigInteger(130, new SecureRandom()).toString(36);

    // Shortener (6) _ не до конца понял пункт реализации метода testStrategy(..)
    // testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет тестировать работу переданной стратегии
    // на определенном количестве элементов elementsNumber. Реализация метода

    // далее о мапах _ + 12 и 13я задачи виды мап из библиотек Apache Commons Collection & Google Guava
    // (14) - JUNIT - тесты
}
