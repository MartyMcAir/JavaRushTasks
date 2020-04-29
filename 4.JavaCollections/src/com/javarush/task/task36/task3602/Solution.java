package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3602#discussion // copy past
// 1. Реализует интерфейс List;
//2. Является приватным статическим классом внутри популярного утилитного класса;
//3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
//Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();

        Class<?> resultClass = Arrays.stream(classes)
                .filter(c -> List.class.isAssignableFrom(c) && Modifier.isPrivate(c.getModifiers())
                        && Modifier.isStatic(c.getModifiers()))
                .filter(c -> {
                    try {
                        c.getDeclaredMethod("get", int.class);
                        Constructor<?> declaredConstructor = c.getDeclaredConstructor();
                        declaredConstructor.setAccessible(true);
                        List list = (List) declaredConstructor.newInstance();
                        list.get(1);
                        return false;
                    } catch (IndexOutOfBoundsException e) {
                        return true;
                    } catch (NoSuchMethodException e) {
                        return false;
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .findFirst().orElse(null);
        return resultClass;
    }

    // Для тех, кто, как и я не понял, что нужно делать.
    //Есть некий класс (спойлеры ниже) в котором есть вложенные классы – коллекции.
    //Один из этих вложенных классов-коллекций соответствует требованиям в задачи:
    //1.	Этот класс или его класс родитель имплементирует класс List
    //2.	Этот класс приватный и статический
    //3.	У этого класса есть приватный метод get(int i) который, если к нему обратиться выкидывает эксепшен
    // «InvocationTargetException», в тексте которого есть текст «IndexOutOfBoundsException»
    //Дальше спойлеры, рекомендую не читать, а попробовать решить самим.
    //Порядок действий (решается через reflection):
    //1.	Получаем (getDeclaredClasses) и обходим все классы у класса Collections
    //2.	Для каждого класса проверяем:
    //a.	Имплементирует ли этот класс или его родитель (getSuperclass) интерфейс List (getInterfaces)
    //b.	Является ли этот класс приватным (Modifier.isPrivate(clazz.getModifiers()))
    //c.	Является ли этот класс статическим (Modifier.isStatic(clazz.getModifiers()))
    //d.	Получаем метод get (getDeclaredMethod("get", int.class)) и устанавливаем ему доступность setAccessible(true)
    //e.	Получаем конструктор (getDeclaredConstructor) и устанавливаем ему доступность  setAccessible(true)
    //f.	Выполняем метод (invoke()) с созданным новым инстансом через конструктор (newInstance()) и любым параметром int
    //g.	Если отловили InvocationTargetException и в getCause() содержится "IndexOutOfBoundsException" –
    // это наш класс, его и возвращаем.
}
