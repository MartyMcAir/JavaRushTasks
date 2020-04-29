package com.javarush.task.task36.task3612;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Почему сет не содержит элемент?
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3612#discussion
// не понял как они хотя изменить последнюю дату, если это HashSet - коорый неупорядочен
// а решение окозалось простым
public class Solution {
    private Set<Date> dates;
    private Date lastDate;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.initializeDates();
        solution.updateLastDate(3_600_000L);
        System.out.println(solution.isLastDateInDates());
    }

    public boolean isLastDateInDates() {
        return dates.contains(lastDate);
    }

    private void initializeDates() {
        dates = new HashSet<>();
        lastDate = new Date(9999999L);
        dates.add(lastDate);
        dates.add(new Date(2222222L));
        dates.add(new Date(3333333L));
        dates.add(new Date(4444444L));
        dates.add(new Date(5555555L));
    }

    protected void updateLastDate(long delta) {
//        lastDate.setTime(lastDate.getTime() + delta);
        dates.remove(lastDate);
        lastDate = new Date(lastDate.getTime() + delta);
        dates.add(lastDate);
    }
}