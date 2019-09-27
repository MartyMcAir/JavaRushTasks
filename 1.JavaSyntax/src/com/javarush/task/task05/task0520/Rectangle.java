package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    private int top, left, width=0, height=0;

    public Rectangle(int left, int top, int width, int height){
        this.left=left;
        this.top=top;
        this.width=width;
        this.height=height;
    }

    public Rectangle(int top, int left, int width){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=width;
    }

    public Rectangle(int top, int left){
        this.top=top;
        this.left=left;
    }

    public Rectangle(int top){
        this.top=top;
    }

    public Rectangle(Rectangle rec){
        this.top = rec.top;
        this.left=rec.left;
        this.width=rec.width;
        this.height=rec.height;
    }

    public static void main(String[] args) {

    }
}
