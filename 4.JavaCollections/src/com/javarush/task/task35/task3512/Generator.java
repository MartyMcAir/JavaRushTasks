package com.javarush.task.task35.task3512;

import java.lang.reflect.InvocationTargetException;

public class Generator<T> {
    // Examples from https://fooobar.com/questions/15718/instantiating-a-generic-class-in-java
    private Class<T> t;
    private Event event;
// https://javarush.ru/tasks/com.javarush.task.task35.task3506#discussion
    public Generator(Class<T> t) {
        this.t = t;
    }

    public T newInstance() throws IllegalAccessException, InstantiationException {
//        return t.newInstance();
        // newInstance() устарел в java 9. рекомендовано к использованию
        // getConstructor().newInstance() и перехватывать в блоке catch ReflectiveOperationException.
        T tnew = null;
        try {
            tnew = t.getConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return tnew;
    }

    public Generator() {
    }

    public Generator(Event event) {
        this.event = event;
    }

    public Event newInstance2() {
        return event;
    }

//    T newInstance4() {
//        T t = new T(); // cannot be instantiated directly
//        return t;
//    }

    Generator<T> newInstance3() {
//        T t = new T();
        return this;
    }
}
