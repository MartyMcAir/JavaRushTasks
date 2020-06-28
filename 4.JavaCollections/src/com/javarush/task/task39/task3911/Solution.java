package com.javarush.task.task39.task3911;

import java.util.Map;

/* 
Rollback
*/
// Необходимо реализовать метод rollback в классе Software,
// который будет позволять откатить текущую версию ПО на желаемую.
// Все версии следующие после той, на которую откатываемся, должны быть удалены,
// также не забудь изменить поле currentVersion.
//Метод rollback должен вернуть true, если все прошло успешно и false,
// если желаемая версия не была найдена.

// https://javarush.ru/tasks/com.javarush.task.task39.task3911#discussion
public class Solution {
    public static void main(String[] args) {
        Software software = new Software();

        for (int i = 1; i < 7; i++) {
            // заполняет LinkedHashMap<Integer, String> и обновляет перменную currentVersion
            software.addNewVersion(i, "Description of version #" + i);
        }

        System.out.println("Printing all versions ");
        for (Map.Entry entry : software.getVersionHistoryMap().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
        System.out.println("The current version is " + software.getCurrentVersion());


        //////////// сам метод отката до нужной версии
        System.out.println("---------------------------");
        int n = 3;  // откат до версии №3 _ т.е. чтоб текущ версия была 3
        // при этом остальные изменениячто >3x, теряем ..
        System.out.println("ROLLING BACK to version " + n);
        software.rollback(n);

        System.out.println("\nPrinting all versions ");
        for (Map.Entry entry : software.getVersionHistoryMap().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
        System.out.println("The current version is " + software.getCurrentVersion());
    }
}
