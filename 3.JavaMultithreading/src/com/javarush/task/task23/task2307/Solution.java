package com.javarush.task.task23.task2307;

/* 
Как выбрать нужное?
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = Solution.TEST; // Это поле
        obj = new Solution.TEST(); // Это объект
//        Solution.TEST ttt = Solution.this.TEST;
//        try {
//            obj = Solution.class.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        System.out.println(obj);
    }
}
