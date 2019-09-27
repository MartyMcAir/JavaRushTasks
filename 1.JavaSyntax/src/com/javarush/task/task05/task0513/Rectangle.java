package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top, left, width=0, height=0;
    Rectangle rectangle;

    public void  initialize(int top, int left, int width, int height){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=height;
    }
    public void  initialize(int top, int left, int width){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=width;  // высота не задана (равно ширине) создаём квадрат
    }
    public void  initialize(int top, int left){
        this.top=top;
        this.left=left;
    }
    public void  initialize(int top){
        this.top=top;
    }

    public void initialize(Rectangle rectangle){
        this.top=rectangle.top;
        this.left=rectangle.left;
        this.width=rectangle.width;
        this.height=rectangle.height;
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle();
        rc.initialize(3,3,3,3);

        Rectangle rc2 = new Rectangle();
        rc2.initialize(3,3);

        Rectangle rc3 = new Rectangle();
        rc3.initialize(3,3,3);

        Rectangle rc4 = new Rectangle();
        rc4.initialize(rc);
    }
}
