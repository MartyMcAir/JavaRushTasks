package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ct1 = reader.readLine();
        String ct2 = reader.readLine();
        String ct3 = reader.readLine();
        String ct4 = reader.readLine();
        String ct5 = reader.readLine();
        String ct6 = reader.readLine();

//        Cat cat1 = new Cat("дедушка Вася"); // дедушка Вася _
//        Cat cat2 = new Cat("бабушка Мурка"); // бабушка Мурка _
//        Cat cat3 = new Cat("папа Котофей", null ,cat1); // папа Котофей _ // дедушка Вася
//        Cat cat4 = new Cat("мама Василиса", cat2, null); // мама Василиса _ // бабушка Мурка
//        Cat cat5 = new Cat("сын Мурчик", cat4, cat3); // сын Мурчик _ // мама Василиса // папа Котофей - cat3
//        Cat cat6 = new Cat("дочь Пушинка", cat4, cat3); // дочь Пушинка _ // мама Василиса // папа Котофей - cat3

        Cat cat1 = new Cat(ct1); // дедушка Вася _
        Cat cat2 = new Cat(ct2); // бабушка Мурка _
        Cat cat3 = new Cat(ct3, null ,cat1); // папа Котофей _ // дедушка Вася
        Cat cat4 = new Cat(ct4, cat2, null); // мама Василиса _ // бабушка Мурка
        Cat cat5 = new Cat(ct5, cat4, cat3); // сын Мурчик _ // мама Василиса // папа Котофей - cat3
        Cat cat6 = new Cat(ct6, cat4, cat3); // дочь Пушинка _ // мама Василиса // папа Котофей - cat3

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
        System.out.println(cat5);
        System.out.println(cat6);
    }

    public static class Cat {
//        У каждой кошки есть имя, кот-папа и кошка-мама.
//        Изменить класс Cat так, чтобы он мог описать данную ситуацию.
        private String name;
        private Cat mother, father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            this.mother = parent1;
            this.father = parent2;
        }

        @Override
        public String toString() {
            String res = "fff", vasya = "дедушка Вася";
            if(mother ==null && father==null){
                res = "The cat's name is "+name+", no mother, no father";
            } else if(mother != null && father==null){
                res= "The cat's name is "+name+", mother is "+mother.name+", no father";
            } else if(mother == null && father!=null){
                res= "The cat's name is "+name+", no mother, father is "+father.name;
            } else if(mother != null && father!=null){
                res= "The cat's name is "+name+", mother is "+mother.name+", father is "+father.name;
            }
            return res;
        }
    }
}
