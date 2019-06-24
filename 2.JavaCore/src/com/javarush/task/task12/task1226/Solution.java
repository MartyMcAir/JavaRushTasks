package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }

    public class Cat implements CanRun, CanClimb{
        @Override
        public void run() {
            System.out.println("rrun");
        }
        @Override
        public void climb(){
            System.out.println("ccllimb");
        }
    }

    public class Dog implements CanRun{
        @Override
        public void run(){
            System.out.println("rrrun");
        }
    }

    public class Tiger extends Cat {

    }

    public class Duck implements CanRun, CanFly{
        @Override
        public void run(){
            System.out.println("ruuun");
        }
        @Override
        public void fly(){
            System.out.println("ffllyy");
        }
    }

    public interface CanFly{
        void fly();
    }
    public interface CanClimb{
        void climb();
    }
    public interface CanRun{
        void run();
    }
}
