package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (o.getClass() != this.getClass() || !(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        // тут если не равен null то проверка на equals если null то и второй null значит true
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return true;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return true;
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return true;

        return true;
    }

    @Override
    public int hashCode() {
//        private int anInt;
//        private String string;
//        private double aDouble;
//        private Date date;
//        private Solution solution;
        int result = anInt + (string == null ? 0 : string.hashCode());
        result += (solution == null ? 0 : solution.hashCode());
        result += Double.doubleToLongBits(aDouble);
        return 31 * result;
    }

    public static void main(String[] args) {

    }
}
