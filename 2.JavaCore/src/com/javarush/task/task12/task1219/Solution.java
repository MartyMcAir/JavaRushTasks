package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public class Human implements CanRun, CanSwim{
        @Override
        public void run(){
            System.out.println("rrrun");
        }
        @Override
        public void swim(){
            System.out.println("sswim");
        }
    }

    public class Duck implements CanFly, CanSwim, CanRun{
        @Override
        public void fly(){
            System.out.println("fffly");
        }
        @Override
        public void swim(){
            System.out.println("sswim");
        }
        @Override
        public void run(){
            System.out.println("rrun");
        }
    }

    public class Penguin implements CanSwim, CanRun{
        @Override
        public void swim(){
            System.out.println("sswim");
        }
        @Override
        public void run(){
            System.out.println("rrun");
        }
    }

    public class Airplane implements CanRun, CanFly{
        @Override
        public void run(){
            System.out.println("run");
        }
        @Override
        public void fly(){
            System.out.println("ffly");
        }
    }
}
