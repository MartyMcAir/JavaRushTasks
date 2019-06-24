package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        String[] arrStr = {"Кот", "Тигр", "Лев", "Бык", "Животное"};
        String res = null;
        if (o instanceof Cat) {
            res = "Кот";
        } else if (o instanceof Tiger) {
            res = "Тигр";
        } else if (o instanceof Lion) {
            res = "Лев";
        } else if (o instanceof Bull) {
            res = "Бык";
        } else { //if(o instanceof Pig){
            res = arrStr[4];
        }
        return res;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
