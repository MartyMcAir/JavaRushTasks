package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        // проверка на null
        if (o == null) {
            return false;
        }
        // если объект не является объектом нужного класса
        if (!(o instanceof Solution) || o.getClass() != this.getClass()) {
            return false;
        }
        // если бъекты равны
        if (this == o) {
            return true;
        }
        // проверки c приведением к типу
        Solution n = (Solution) o;
        if (first != n.first)
            return false;
        if (last != n.last)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
