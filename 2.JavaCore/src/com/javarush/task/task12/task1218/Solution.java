package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanMove, CanEat{
        @Override
        public void move(){
            System.out.println("mooove");
        }
        @Override
        public void eat(){
            System.out.println("eeeat");
        }
    }

    public class Duck implements CanMove, CanEat, CanFly{
        @Override
        public void move(){
            System.out.println("move");
        }
        @Override
        public void eat(){
            System.out.println("eeeeat");
        }
        @Override
        public void fly(){
            System.out.println("fffly");
        }
    }

    public class Car implements CanMove{
        @Override
        public void move(){
            System.out.println("mooove");
        }
    }

    public class Airplane implements CanMove, CanFly{
        @Override
        public void move(){
            System.out.println("moove");
        }
        @Override
        public void fly(){
            System.out.println("fffly");
        }
    }
}
