package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;

/*
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Class<Item> itemClass = Item.class;
        test(solution.getProxy(itemClass));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

//    public static Object getProxy(Class<? extends Item> item) { //    }
//    public static Object getProxy(Class<? extends Item> item, Class<Small> small) { //    }
//    public static Object getProxy(Class<Item> item, Class<Big> big, Class<Small> small){ //    }

    // а вот так не сработает
//    public static Object getProxy(Class<Object>... item){    }

    // Or _ WildCards массив, переменной длины...
//    public static Object getProxy(Class<?>... item) { }

    // Or
//    public static <T> Object getProxy(Class<T> clazz, Class<?>... interfaces) {

    public <T extends Item> T getProxy(Class<T> srcClass, Class... classes) {
        ItemInvocationHandler handler = new ItemInvocationHandler(); // перехватчик оригинала
        ClassLoader classLoader = srcClass.getClassLoader(); // ClassLoader оригинала

        // создаем массив интерфейсов нужной длины взятой и переменной длины.. varargs
        Class<?>[] interfacesArr = new Class[classes.length + 1];
        interfacesArr[0] = srcClass; // Сеттим 1ый аргумент, первым элементом массива

        // Первым параметром является массив-источник.
        // Вторым параметром является позиция начала нового массива.
        // Третий параметр — массив-назначения.
        // Четвертый параметр является начальным положением целевого массива.
        // Последний параметр это количество элементов, которые будут скопированы.
        System.arraycopy(classes, 0, interfacesArr, 1, classes.length);

        return (T) Proxy.newProxyInstance(classLoader, interfacesArr, handler);
    }

    // демонстрирует "прикручен" ли конкретный интерфейс к данному прокси.
    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}