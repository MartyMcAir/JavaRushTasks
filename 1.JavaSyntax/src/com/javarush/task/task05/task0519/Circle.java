package com.javarush.task.task05.task0519;

/* 
Ходим по кругу
*/


public class Circle {
    private int centerX, centerY, radius, width, color;

    // 2. принимающий в качестве параметров centerX, centerY, radius и инициализирующий соответствующие переменные класса.
    public Circle(int centerX, int centerY, int radius){
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
    }
    // 3. параметров centerX, centerY, radius, width и инициализирующий соответствующие переменные класса.
    public Circle(int centerX, int centerY, int radius, int width){
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
        this.width=width;
    }
    // 4. параметров centerX, centerY, radius, width, color и инициализирующий соответствующие переменные класса.
    public Circle(int centerX, int centerY, int radius, int width, int color){
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
        this.width=width;
        this.color=color;
    }

    public static void main(String[] args) {

    }
}
