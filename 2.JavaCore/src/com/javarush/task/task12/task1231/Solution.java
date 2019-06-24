package com.javarush.task.task12.task1231;

/* 
Ненужные абстракции
*/

public class Solution {

    public static void main(String[] args) {
        Horse horse = new Pegasus();
        horse.run();
        ((Pegasus) horse).fly(); // приведение к типу _ нисходящее от СуперКласса к наследнику

        Horse h1 = new Horse();
        h1.run();

        Pegasus p1 = new Pegasus();
        p1.fly();
    }

    public static interface CanFly {
        public abstract void fly();
    }

    public static class Horse { // delete abstract
        public void run() {
            System.out.println("rrruunn");
        }
    }

    public static class Pegasus extends Horse implements CanFly {
        public void fly() { // delete abstract
            System.out.println("fflyyy");
        }
    }

    public static abstract class SwimmingPegasus extends Pegasus { // add abstract
        public abstract void swim();
    }

}
