package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    private String name;
    private int age = 3, weight = 3;
    private String address, color = "black";

    // 6. параметра имя, но инициализирующий все переменные класса, кроме адреса.
    public Cat(String name) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    // 7. параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    // 8. параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
    public Cat(String name, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    // 9. параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = age;
    }

    // 10. параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = age;
    }

    public static void main(String[] args) {

    }
}
