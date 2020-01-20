package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        //        private ArrayList<Comparator<T>> comparators = new ArrayList<>();
        private Comparator<T>[] comparators;

        @SafeVarargs
        public CustomizedComparator(Comparator<T>... comparator) {
//            comparators.addAll(Arrays.asList(comparator));
            this.comparators = comparator;
        }

        @Override
        public int compare(T o1, T o2) {
            int res = 0;
            for (Comparator<T> elem : comparators) {
                res = elem.compare(o1, o2);
                if (res != 0) {
                    return res;
                }
            }
            return 0;
        }
    }
}
