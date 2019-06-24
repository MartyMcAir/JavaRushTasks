package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        String[] arrStr = {"Кот", "Тигр", "Лев", "Бык", "Корова", "Животное"};
        String res = null;
        // Не делайте проверку с помощью instanceof так как такая проверка будет возвращать true
        // для подклассов и будет работать правильно только в случае если ваш класс объявлен как immutable.
//        if (o instanceof Cat) {
//            res = arrStr[0];
//        }
//         if (o.hashCode() == new Tiger().hashCode()){ //
        if (o.equals(new Cat())) {
            res = arrStr[0];
        } else if (o.equals(new Tiger())) {
            res = arrStr[1];
        } else if (o.equals(new Lion())) {
            res = arrStr[2];
        } else if (o.equals(new Bull())) {
            res = arrStr[3];
        } else if (o.equals(new Cow())) {
            res = arrStr[4];
        } else {
            res = arrStr[5];
        }
        return res;
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
        @Override
        public boolean equals(Object o) {
            boolean res = false;
//            if(o.hashCode() == new Tiger().hashCode()){
//                res=true;  // не работает
//            }
//            if (o == this) {
            // так же для полного сходства можно добавитьсранение полей
            if (o != null & o.getClass() == this.getClass()) {
                res = true;
            }
            return res;
        }

        @Override
        public int hashCode() {
            final int prime = 0;
            int res = 1;
            res = prime * res;
            return res;
        }
    }

    public static class Lion extends Cat {
        @Override
        public boolean equals(Object o) {
            return o != null & o.getClass() == this.getClass() ? true : false;
        }
    }

    public static class Bull extends Animal {
        @Override
        public boolean equals(Object o) {
            return o != null & o.getClass() == this.getClass() ? true : false;
        }
    }

    public static class Cow extends Animal {
        @Override
        public boolean equals(Object o) {
            return o != null & o.getClass() == this.getClass();
        }
    }

    public static class Animal {
        @Override
        public boolean equals(Object o) {
            return o != null & o.getClass() == this.getClass();
        }
    }
}
