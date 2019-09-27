package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg tanos1 = new Zerg();
        Zerg tanos2 = new Zerg();
        Zerg tanos3 = new Zerg();
        Zerg tanos4 = new Zerg();
        Zerg tanos5 = new Zerg();
        tanos1.name="tanos1";
        tanos2.name="tanos2";
        tanos3.name="tanos3";
        tanos4.name="tanos4";
        tanos5.name="tanos5";

        Protoss nebula1 = new Protoss();
        Protoss nebula2 = new Protoss();
        Protoss nebula3 = new Protoss();
        nebula1.name = "nebula1";
        nebula2.name = "nebula2";
        nebula3.name = "nebula3";

        Terran gomora1 = new Terran();
        Terran gomora2 = new Terran();
        Terran gomora3 = new Terran();
        Terran gomora4 = new Terran();
        gomora1.name = "gomora1";
        gomora2.name = "gomora2";
        gomora3.name = "gomora3";
        gomora4.name = "gomora4";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
