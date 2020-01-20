package com.javarush.task.task23.task2305;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        // wrong
//        Solution sol1 = new Solution();
//        sol1.innerClasses[0] = new InnerClass(); // InnerClass - not bee a static
//        sol1.innerClasses[1] = new InnerClass(); //
//        Solution sol2 = new Solution();
//        solutions[0] = sol1.innerClasses[0]= solutions[0].new innerClasses(); // non staticfield
//        solutions[1] = sol2;

        // через массив получаем к полю доступ к элементу след массива
        // и далее присваиваем ему ..
//        solutions[0].innerClasses[0] = solutions[0].new InnerClass(); // работает
        // right
        for (int i = 0; i < solutions.length; i++) {
            solutions[i] = new Solution();
            solutions[i].innerClasses[0] = solutions[i].new InnerClass();
            solutions[i].innerClasses[1] = solutions[i].new InnerClass();
        }
        return solutions;
    }

    public static void main(String[] args) {

    }


}
