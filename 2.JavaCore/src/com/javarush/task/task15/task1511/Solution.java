package com.javarush.task.task15.task1511;

import java.io.Serializable;

/* 
Максимально простой код-1
Вы уже в курсе, что упрощать — сложно, а усложнять — просто. Давайте сделаем что-то сложное
(хотя не слишком-то): упростим код. Для этого уберём все наследования и реализации,
которые и так будут добавлены автоматически при компиляции.
*/

public class Solution {
    public static void main(String[] args) {
        JuniorJavaDev me = new JuniorJavaDev();
        System.out.println(me.askHubert("What do you think about com.javarush.task.task15.task1511?"));
        System.out.println(me.askZapp("When will the next update happen?"));
    }

    public interface SpecificSerializable extends Serializable {
    }

    public static class JavaDev implements SpecificSerializable { // extends Object
        String answerQuestion(String question) {
            return String.format("I'll be thinking of [%s]", question);
        }
    }

    public static class JuniorJavaDev extends JavaDev{ // implements SpecificSerializable
        JavaDev zapp = new JavaDev();
        JavaDev hubert = new JavaDev();

        String askZapp(String question) {
            return zapp.answerQuestion(question);
        }

        String askHubert(String question) {
            return hubert.answerQuestion(question);
        }
    }
}
