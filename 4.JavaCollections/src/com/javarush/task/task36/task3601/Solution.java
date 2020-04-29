package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/* 
MVC - простая версия
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3601#discussion
// Solution->View->Controller->Model->Service

// немного неожиданно. на стажировке мы делали проект, где сервисы - это слой между контроллерами и репозиторием.
// как раз в этот слой выносили логику действий с данными, а доступ к данным (в т.ч. в БД)
// осуществлялся через нижележащий слой репозиторий.
//а в этой задаче почему-то Сервис - самый нижний слой.

// Повторяем как мантру:
//M - get
//V - fire
//C - on
//и всё будет хорошо)
public class Solution {
    public static void main(String[] args) {
//        new Solution().fireShowDataEvent();
        new View().fireShowDataEvent();
    }







}
