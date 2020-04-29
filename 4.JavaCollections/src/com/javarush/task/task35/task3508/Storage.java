package com.javarush.task.task35.task3508;

import java.util.*;
import java.util.function.Predicate;

public class Storage<K, V> implements MyObjectStore<K, V> {
    private String storageName;
    private Map<K, V> map = new HashMap<>();

    public Storage(String storageName) {
        this.storageName = storageName;
    }

    public static void main(String[] args) {
        Storage<Long, String> carsStorage = new Storage<>("carsStorage");
        carsStorage.put(1L, "Audi");
        carsStorage.put(2L, "Honda");

        Map<Long, String> cars = new HashMap<>();
        cars.put(3L, "Tesla");
        cars.put(3L, "BatmanMobile");
        carsStorage.getMap().forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        carsStorage.putAll(cars);
        carsStorage.getMap().forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        List<?> list = new ArrayList<>();
//        list.add((String) "string");
    }


    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void putAll(Map<K, V> entries) {
        map.putAll(entries);
    }

//    public void putAll(Map<? extends K, ? extends V> entries) {
//        map.putAll(entries);
//    }

    @Override
    public Map<K, V> getAll(Collection<K> keys) {
        return map;
    }

    @Override
    public Collection<V> getAll(Predicate<V> p) {
        return map.values();
    }

    public Map<K, V> getMap() {
        return map;
    }

    public static class StorageEntry<T> {
        private T t;
    }
}
