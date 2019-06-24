package com.javarush.task.task12.task1227;

/* 
CanFly, CanRun, CanSwim для классов Duck, Penguin, Toad
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

    public class Duck implements CanFly, CanRun, CanSwim{
        @Override
        public void fly(){
            System.out.println("flyy");
        }
        @Override
        public void run(){
            System.out.println("run");
        }
        @Override
        public void swim(){
            System.out.println("swimm");
        }
    }

    public class Penguin implements CanSwim, CanRun{
        @Override
        public void swim(){
            System.out.println("swim");
        }
        @Override
        public void run(){
            System.out.println("rrun");
        }
    }

    public class Toad implements CanSwim{
        @Override
        public void swim(){
            System.out.println("ssswimm");
        }
    }
}
