package com.javarush.task.task21.task2109;

import java.time.chrono.ChronoLocalDate;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new A(this.i, this.j);
        }

        @Override
        public int hashCode() {
            return 31 * (i + j);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass() || !(obj instanceof A)) return false;
            if (obj == this) return true;

            A newA = (A) obj;
            if (this.i != newA.i || this.j != newA.j) return false;
            return true;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
//            return new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {

        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public int hashCode() {
            return 31 * (super.getI() + super.getJ());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass() || !(obj instanceof C)) return false;
            if (obj == this) return true;

            C cNew = (C) obj;
            if (super.getI() != cNew.getI() || super.getJ() != cNew.getJ()) return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            C cNew = new C(super.getI(), super.getJ(), super.getName());
            return cNew;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A aV = new A(2, 3);
        A copyA = (A) aV.clone();

        System.out.println(aV.getI() + " " + aV.getJ());
        System.out.println(copyA.getI() + " " + copyA.getJ());
        System.out.println(aV.equals(copyA) + " " + aV + "_" + copyA);

        C cV = new C(4, 6, "test");
        C copyC = (C) cV.clone();
        System.out.println(cV.getI() + " " + cV.getJ());
        System.out.println(copyC.getI() + " " + copyC.getJ());
        System.out.println(cV.equals(copyC) + " " + cV + "_" + copyC);

        B bV = new B(99, 88, "B dNot Cloneable");
        System.out.println(bV + " " + bV.getName());
        B copyB = (B) bV.clone();
        System.out.println(copyB + " " + copyB.getName());
    }
}
