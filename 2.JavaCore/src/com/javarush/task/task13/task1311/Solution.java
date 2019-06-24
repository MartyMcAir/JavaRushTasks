package com.javarush.task.task13.task1311;

/* 
Нанимаем переводчика
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        EnglishTranslator englishTranslator = new EnglishTranslator();
        System.out.println(englishTranslator.translate());
    }

    public static abstract class Translator {
        public abstract String getLanguage();

        public String translate() {
            return "Я переводчик с " + getLanguage();
        }
    }

    // code  __ если EnglishTranslator не static то строка
    // EnglishTranslator englishTranslator = new EnglishTranslator(); - не будет работать т.к.
    // main является static а вызываемы класс является внутренним классом Solution
    public static class EnglishTranslator extends Translator{
        @Override
        public String getLanguage(){
            return "английского";
        }
    }
}