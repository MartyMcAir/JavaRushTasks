package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // если объектв равны
        if (obj == null) return false;

        // если их классы не равны
        if (obj.getClass() != this.getClass()) return false;
        if (!(obj instanceof Solution)) return false;

        Solution other = (Solution) obj;
        if (first != other.first)
            return false;
        if (last != other.last)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
//        return 31 * (this.first.hashCode() + this.last.hashCode());
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
//        System.out.println(s.contains(new Solution("Donald", "Duck")));

        Solution s1 = new Solution("Donald", "Duck");
        Solution s2 = new Solution("Donald", "Duck");

        String st1 = null;
        String st2 = null;
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
    }
}
