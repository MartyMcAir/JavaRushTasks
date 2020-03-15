package com.javarush.task.task33.task3313;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* 
Сериализация даты в JSON
*/
public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        Event event = new Event("event#1");
        String result = new ObjectMapper().writeValueAsString(event);
        //new ObjectMapper().setDateFormat(new SimpleDataFormat("dd-MM-yyyy hh:mm:ss")).writeValueAsString(event);
        System.out.println(result);
    }
}
