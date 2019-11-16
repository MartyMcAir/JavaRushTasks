package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        A varA = null;
        try { // instanceof здесь не нужен т.к. при обработке исключений сработает штатно (с комментов)
            varA = (A) objectStream.readObject();
        } catch (ClassNotFoundException e) {   // если класс не найден
            e.printStackTrace();
            varA = null;
        } catch (ClassCastException e) {   // ошибка приведения типов (*) *..
            e.printStackTrace();
            varA = null;
        } catch (IOException e) {   //  проблема с потоками
            e.printStackTrace();
            varA = null;
        } catch (Exception e) {   //  для всего остального
            e.printStackTrace();
            varA = null;
        }
        return varA;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream btArr = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(btArr));
        Solution sol = new Solution();
        A varA = sol.new A();
        objOut.writeObject(varA);
        objOut.close();

        ObjectInputStream objIn = new ObjectInputStream(new BufferedInputStream(
                new ByteArrayInputStream(btArr.toByteArray())));
        A newA = (A) objIn.readObject();
        System.out.println(newA + " _ " + varA);
        objIn.close();

//        Solution sol = new Solution();
//        A varT = (A) sol.getOriginalObject(objIn);
    }
}
