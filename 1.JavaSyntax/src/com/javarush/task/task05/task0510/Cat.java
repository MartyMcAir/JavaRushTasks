package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    private String name;
    private int age=2;
    private int weight=3;
    private String address, color="black";

    // 7. (1) параметра имя, но инициализирующий все переменные класса, кроме адреса.
    public void initialize(String name){
        this.name=name;
        this.age=age; // иниициализирующий все переменные класса, кроме адреса.
        this.weight=weight; //
        this.color=color; //
    }
    // 8. (2) параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
    public void initialize(String name, int weight, int age){
        this.name=name;
        this.weight=weight;
        this.age=age;
        this.color=color; // иниициализирующий все переменные класса, кроме адреса
    }
    // 9. 3) параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
    public void initialize(String name, int age){
        this.name=name;
        this.age=age;
        this.weight=weight; // вес стандартный
        this.color=color; // иниициализирующий все переменные класса, кроме адреса
    }
    // 10. (4) параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
    public void initialize(int weight, String color){
        this.weight=weight;
        this.color=color;
        // this.name=null; // неизвестны т.к. бездомный кот
        // this.address=null; // инициализирующий все переменные класса, кроме имени и адреса.
        this.age=age; //
    }
    // 11. (5) параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
    public void initialize(int weight, String color, String address){
        this.weight=weight;
        this.color=color;
        this.address=address; // чужой домашний кот
        this.age=age;
        // this.name=name; // кроме имени.
    }
    public static void main(String[] args) {

    }
}
