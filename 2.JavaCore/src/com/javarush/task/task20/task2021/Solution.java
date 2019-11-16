package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
//                public String name = "fff";
//
//        private Object readResolve() {
//            SubSolution sub = new SubSolution();
//            sub.name = "zz";
//            return sub;
//        }
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new NotSerializableException();
        }
        private void readObjectNoDate(ObjectInputStream in) throws IOException {
            throw new NotSerializableException();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream btArr = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(btArr));
        SubSolution subS = new SubSolution();
        objOut.writeObject(subS);
        objOut.close();

        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(btArr.toByteArray()));
        SubSolution subNew = (SubSolution) objIn.readObject();
        objIn.close();

        System.out.println(subS + " _ " + subNew);
//        System.out.println(subS.name + " _ " + subNew.name);
    }
}
