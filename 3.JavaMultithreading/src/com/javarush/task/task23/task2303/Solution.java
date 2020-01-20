package com.javarush.task.task23.task2303;

/* 
Запрети создание экземпляров класса
*/
public class Solution {

    public abstract static class Listener { // нельзя создавать экземпляры абстрактного класса
        private Listener() {
        }

        public void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
            System.out.println("fff" + x + ", " + y);
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {
//        Listener ls = new Listener();
//        ls.onMouseDown(3, 6);
    }
}
