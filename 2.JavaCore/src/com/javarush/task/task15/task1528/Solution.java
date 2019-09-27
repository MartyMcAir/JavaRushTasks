package com.javarush.task.task15.task1528;

/* 
ООП. Hrivna — тоже деньги
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        // рекурсия приводящяя к StackOverflowError
        public Object getAmount() { // getMoney вызывает getAmount который вызывает getMoney
            return getMoney().getAmount();
        }
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        private double amount = 123d;

        @Override
        Hrivna getMoney() {
            return this;
        }

        @Override // без переопределения этого метда будет StackOverflowError
        public Object getAmount() {
//            return super.getAmount(); // StackOverflowError
            return this.amount;
        }

//        @Override
//        public String toString(){
//            return Double.toString(this.amount);
//        }
    }
}
