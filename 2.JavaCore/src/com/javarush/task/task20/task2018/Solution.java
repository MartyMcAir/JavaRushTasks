package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable { // Serializable - added
    public static class A {

        protected String nameA = "A";

        //you need this default constructor for proper deserialization
        public A() {
        } // без конструктора ошибка

        public A(String nameA) {
            this.nameA += nameA;
        }
    }


    public class B extends A implements Serializable {

        private String nameB;

//        public B() {
//        } // тож надо пустой констр..

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }


        private void writeObject(ObjectOutputStream objOut) throws IOException {
            objOut.defaultWriteObject();
            objOut.writeObject(nameA);
        }

        private void readObject(ObjectInputStream objIn) throws IOException, ClassNotFoundException {
            objIn.defaultReadObject();
            this.nameA = (String) objIn.readObject();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
