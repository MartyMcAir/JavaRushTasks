package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() { // code
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(firstName); // writeChars
            out.writeUTF(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readUTF(); // readLine
            lastName = in.readUTF();
            father = (Person) in.readObject();
            mother = (Person) in.readObject();
            age = in.readInt();
//            children = (List) in.readObject(); // OptionalDataException -> (List)
            children = (List<Person>) in.readObject(); // OptionalDataException
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrBt = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(arrBt);
        Person lelush = new Person("Lelush", "Lamperush", 16);

        // for NullPointeException _ _ _ OptionalDataException
        Person suka = new Person("Yumi", "Sakanema", 8);
        ArrayList<Person> perList = new ArrayList<>();
        perList.add(suka);

        lelush.setChildren(perList);
        objOut.writeObject(lelush);
        objOut.flush();

        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(arrBt.toByteArray()));
        Person per = (Person) objIn.readObject();
        System.out.println(per.lastName);
        objIn.close();
    }
}
