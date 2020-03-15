package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException, ClassNotFoundException {
//        StringWriter stringWriter = new StringWriter();
//        List<String> list = Files.readAllLines(Paths.get(fileName));
//        for (String item : list)
//            stringWriter.write(item);

        // OR NOt My
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//            StringBuffer sb = new StringBuffer("");
//            while (fileReader.ready())
//                sb.append(fileReader.readLine());
//
//            reader = new StringReader(sb.toString());
//        }

        // валя не принял
//        StringReader stringReader = new StringReader(stringWriter.toString());
        // Or
//        String jsonStr = Files.readAllLines(Paths.get(fileName)).stream().reduce(String::concat).get();

        ObjectMapper mapper = new ObjectMapper();
//        mapper.reader(Class.forName(stringWriter.toString())); // reader(..) - DEPRECATED
//        T t = mapper.readValue(stringWriter.toString(), clazz);
//        T t = mapper.readValue(stringReader, clazz);
        T t = mapper.readValue(new FileReader(new File(fileName)), clazz);
        return t;
    }

    public static void main(String[] args) {

    }
}
