package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        //         //2. Также этим модификатором мы отмечаем поля String fullName, final String greetingString,
        //         т.к эти данные для сериализации являются лишними (можно их отметить, но не нужно),
        //         ведь есть более красивое решение восстановить объект, имея входных данных по минимуму,
        //         и передав их в конструктор Person. При этом после восстановления мы получаем полноценный
        //         рабочий объект, в котором transient поля (которые были проигнорированы сериализацией) - инициализированы.
        String firstName;
        String lastName;
        transient String fullName;   // ? собирается из firstName и lastName в конструкторе
        transient final String greeting;   // ? это поле не используется _ true если не transient
        String country;
        Sex sex;
        transient PrintStream outputStream; // transient
        transient Logger logger; // transient

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private Object readResolve() { // а вот с этим метом всё true даже с transient полями
            return new Person(this.firstName, this.lastName,
                    this.country, this.sex);
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream btArr = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(btArr));
        Person tanuki = new Person("Tanuki", "Chan", "Japan'es", Sex.MALE);
        objOut.writeObject(tanuki);
        objOut.close();

        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(btArr.toByteArray()));
        Person loadedPer = (Person) objIn.readObject();
        objIn.close();

        System.out.println("sex:" + tanuki.sex.equals(loadedPer.sex));
        System.out.println("greeting: " + tanuki.greeting + "" + loadedPer.greeting + " __ "
                + tanuki.greeting.equals(loadedPer.greeting));
        System.out.println("fullName: " + tanuki.fullName + " " + loadedPer.fullName + " __ "
                + tanuki.fullName.equals(loadedPer.fullName));
    }
}
