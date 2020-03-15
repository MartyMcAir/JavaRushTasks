package com.javarush.task.task34.task3413;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.text.DecimalFormat;

/*
Кеш на основании SoftReference
*/
// https://javarush.ru/tasks/com.javarush.task.task34.task3413#discussion
public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();
        // подсчет затраченной памяти
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // AnyObject - обычный объект с полями и equals() hashCode(..) toString()
        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
//            System.out.println(cache.get(i));
        }

        DecimalFormat format = new DecimalFormat("###,###.###");
        long usedMemory = memoryBean.getHeapMemoryUsage().getUsed() / 1024;
        System.out.println("Used memo: " + format.format(usedMemory));
    }

    //	Я вот как понял(надеюсь кому-то поможет): у нас есть объект, который мы хотим поместить в хэшмап, но так же,
    //	мы не хотим держать в голове и при неуверенности проверять, что все объекты-ключи в нашей хэшмапе существуют(!=null).
    //	Тогда мы берем WeakHashMap, которая реализована так, что, если на объект-ключ указывают только слабые ссылки,
    //	то он будет удален из WeakHashMap. Заметьте, что ссылок strong больше нет - это обязательное условие, ну,
    //	и soft, кстати говоря, тоже, иначе объект не будет удален сборщиком и будет дальше существовать в куче(heap),
    //	и как следствие останется в WeakHashMap.

    // Для тех кто не понял зачем задача: попробуйте проверить размер cachemap после цикла, попробуйте удалить
    // или добавить новый объект.
    //А теперь создайте в main обычный hashmap и попытайтесь его заполнить в аналогичном цикле, не выйдет,
    // потому что выкинет исключение.... угадайте какое.
    // В случае с нашим cachemap все в порядке, сколько бы памяти под JVM мы не выставляли- программа
    // завершается корректно, все из за того, что GC во время успевает подчистить память по мягким ссылкам.
    //Чтобы это проверить попробуйте поставить память для программы поменьше, например я сделал такие: -Xms256m -Xmx512m
    //В итоге цикл завершился корректно и размер cachemap, как и положено 2_500_000 элементов.
    // Однако когда я захотел просмотреть по ключу нужный мне Anyobject, я получил null.
    // Так как объекты были удалены GC, чтобы выделить память. Вот вам и временное хеширование.

}