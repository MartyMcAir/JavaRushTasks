package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        // 4 объекта без отца и матери и 5 объектов с ними)).
        // Два дедушки, две бабушки, отец, мать, трое детей.

        // grang parents
        Human pavel = new Human("Павел", true, 68);
        Human katya = new Human("Катя", false, 55);
        Human pavel2 = new Human("Павел2", true, 83);
        Human katya2 = new Human("Катя2", false, 56);

        // parents
        Human anya = new Human("Аня", false, 21, pavel, katya);
        Human mixail = new Human("Михаил", true, 35, pavel2, katya2);

        // kids = 3
        Human igor = new Human("Игорь", true, 2, mixail, anya);
        Human igor2 = new Human("Игорь2", true, 3, mixail, anya);
        Human igor3 = new Human("Игорь3", false, 4, mixail, anya);

        System.out.println(pavel);
        System.out.println(katya);
        System.out.println(pavel2);
        System.out.println(katya2);
        System.out.println(anya);
        System.out.println(mixail);
        System.out.println(igor);
        System.out.println(igor2);
        System.out.println(igor3);
    }

    public static class Human {

        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father, mother;

        Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}