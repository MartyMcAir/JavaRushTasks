package com.javarush.task.task37.task3707;

public class Tmp {
    // AmigoSet (2)
    //Изобретать механизм работы с хешем не будем, он уже реализован во многих коллекциях.
    //Мы возьмем коллекцию HashMap и воспользуемся ей.
    //1. Создай приватную константу Object PRESENT, которую инициализируй объектом Object, это будет наша заглушка.
    //2. Создай private transient поле HashMap<E,Object> map. Список ключей будет нашим сэтом,
    // а вместо значений будем пихать в мапу заглушку PRESENT.
    //Напомню, нам нужны только ключи, а вместо значений для всех ключей будем вставлять PRESENT.

    // AmigoSet (4) __ copy past _ не дошло зачем приводить к  newSet.map
    //Твое собственное множество AmigoSet реализует интерфейс Cloneable. Однако, не клонируется правильно.
    //Напиши свою реализацию метода Object clone(), сделай поверхностное клонирование.
    //
    //* Клонируй множество, клонируй map.
    //* В случае возникновения исключений выбрось InternalError.
    //* Убери лишнее пробрасывание исключения.

    // AmigoSet (5) __ look and write (not copy past..)
    //Твое собственное множество AmigoSet реализует интерфейс Serializable. Однако, не сериализуется правильно.
    //1. Реализуй свою логику сериализации и десериализации.
    //Вспоминай, какие именно приватные методы нужно добавить, чтоб сериализация пошла по твоему сценарию.
    //Для сериализации:
    //* сериализуй сет
    //* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации. _ НЕ ПОНЯЛ _
    //Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.
}