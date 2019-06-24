package com.javarush.task.task08.task0813;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        //напишите тут ваш код
        Set<String> set = new HashSet<String>();
        Collections.addAll(set, "Лампа", "Легко", "Лорец", "Лидер", "Лягушка", "Лама", "Лектория", "Лекция");
        Collections.addAll(set, "Лошадь", "Ложка", "Лопух", "Ландыш", "Лавадна", "Лоджия", "Люстра", "Ликало");
        Collections.addAll(set, "Лук", "Леший", "Леденец");
        set.add("Лактус");
        return set;
    }

    public static void main(String[] args) {

    }
}
