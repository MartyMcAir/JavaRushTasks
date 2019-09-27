package com.javarush.task.task17.task1719;

import java.util.HashMap;
import java.util.Map;

/* 
ApplicationContext
*/
// не понял где взяли GenericsBean?
/// Это обобщения дженерики переменная для передачи типов.
// GenericsBean это переменная которая может принять любой тип ограниченная типом Bean
public abstract class ApplicationContext<GenericsBean extends Bean> {
// GenericsBean является 2м аргументом т.е. явл значением value
    // ресурс один на все нити так что добавил volatile
    private volatile Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    // Map<Name, some class that implements the Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }
    // почему что бы получить надо synchronized ? в чем проблема отдать!?
    public synchronized GenericsBean getByName(String name) {
          return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}
