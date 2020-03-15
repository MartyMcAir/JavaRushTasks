package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
// копипаст _ меняет имя класса местами
public class Solution {
    public static void main(String[] args) throws IOException {
        First one = new First();
        one.name = "Thanos";
        Second second = new Second();
        second.name = "Nebula";

        Second s = (Second) convertOneToAnother(one, Second.class);
        First f = (First) convertOneToAnother(second, First.class);

        System.out.println(s);   // Second{i=0, name='Thanos'}
        System.out.println(f);   // First{i=0, name='Nebula'}
    }

    // copy past
    // from https://github.com/fighter-hd/JavaRushTasks/blob/master/4.JavaCollections/src/com/javarush/task/task33/task3304/Solution.java
    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS); // отключаем Аннотации
        mapper.writeValue(writer, one);  // записываем в writer 1ый объект

        StringReader reader = new StringReader(writer.toString()); // для чтения из writer
        Object two = mapper.readValue(reader, resultClassObject); // на выходе нужный объект
        return two;
    }

    public static Object convertOneToAnotherByReplace(Object one, Class resultClassObject) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, one);

        String oneClassName = one.getClass().getSimpleName().toLowerCase();
        String resClassName = resultClassObject.getSimpleName().toLowerCase();
        String replaceStr = stringWriter.toString().replaceFirst(oneClassName, resClassName);

        return objectMapper.readValue(new StringReader(replaceStr), resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;

        @Override
        public String toString() {
            return "First{" + "i=" + i + ", name='" + name + '\'' + '}';
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;

        @Override
        public String toString() {
            return "Second{" + "i=" + i + ", name='" + name + '\'' + '}';
        }
    }
}
