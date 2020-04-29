package com.javarush.task.task35.task3509;

import java.util.*;

/*
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    //    public static ArrayList newArrayList(Object... elements) {
//    public static ArrayList newArrayList(Object<T>... elements) {
//    public static <T> ArrayList newArrayList(T... elements) {
    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> list = new ArrayList<>();
        for (T item : elements)
            list.add(item);
        return list;
    }

    //    public static <T> HashSet newHashSet(T... elements) {
    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> set = new HashSet<>();
        for (T item : elements)
            set.add(item);
        return set;
    }

    // public static <K, V> - параметрезирован метод типами <K, V>
    // Map<K, V> - возвращает мапу с теми же типами что и принимал списки
//    public static  Map newHashMap(List keys, List values) {
    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) throw new IllegalArgumentException();
        //напишите тут ваш код
        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            K k = keys.get(i);
            V v = values.get(i);
            map.put(k, v);
        }
        return map;
    }
}
