package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String) in.readObject();
            this.year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment ap = new Apartment("New York", 3000);
        ByteArrayOutputStream btOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(btOut);
        objOut.writeObject(ap);
        objOut.flush();

        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(btOut.toByteArray()));
        Apartment apNew = (Apartment) objIn.readObject();
        System.out.println(apNew.address);
//        System.out.println(btOut.toString());
        objIn.close();
    }
}
