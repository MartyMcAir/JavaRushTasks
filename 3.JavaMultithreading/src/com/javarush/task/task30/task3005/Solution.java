package com.javarush.task.task30.task3005;

import java.util.ArrayList;
import java.util.List;

/* 
Такие хитрые исключения!
*/
// логические операторы понятно _ но что за исключение они хотят убрать _!? код работает без выброса искл..
// Исправь реализацию метода checkAFlag, чтобы во всех случаях он не приводил к бросанию исключений.
// Сохрани логику вывода данных. _
// не понял вообще ничего
public class Solution {
    public static void main(String[] args) {
        checkAFlag(new D());

    }

    public static void checkAFlag(D d) {
        try {
            if (d.cs.get(0).bs.get(0).as.get(0).flag) {
                System.out.println("A's flag is true");
            } else { //all other cases
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Oops!");
        }
    }

    public static void checkAFlaMyg(D d) {
        if (d != null && d.cs != null && d.cs.get(0) != null && d.cs.get(0).bs != null &&
                d.cs.get(0).bs.get(0) != null && d.cs.get(0).bs.get(0).as != null
                && d.cs.get(0).bs.get(0).as.get(0) != null &&
                // не прошло
                // проверка кол-ва элементов _ isEmpty() им не подходит - хотя про из книг такой подход считают верным
//                !d.cs.isEmpty() && !d.cs.get(0).bs.isEmpty() && !d.cs.get(0).bs.get(0).as.isEmpty() &&
                // d.cs содержит хотя бы один элемент. Иначе вывод "Oops!". _ тоже не проходит
                d.cs.size() != 0 && d.cs.get(0).bs.size() > 0 && d.cs.get(0).bs.get(0).as.size() > 0 &&
                // дефолтная проверка
                d.cs.get(0).bs.get(0).as.get(0).flag) {
            System.out.println("A's flag is true");
        } else { //all other cases
            System.out.println("Oops!");
        }
    }

    static class A {
        boolean flag = true;
    }

    static class B {
        List<A> as = new ArrayList<>();

        {
            as.add(new A());
        }
    }

    static class C {
        List<B> bs = new ArrayList<>();

        {
            bs.add(new B());
        }
    }

    static class D {
        List<C> cs = new ArrayList<>();

        {
            cs.add(new C());
        }
    }
}
