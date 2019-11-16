package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        while (speed > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (speed < 3) { // прерываем при нужном нам значении на др. блок кода
//                Thread.currentThread().interrupt();
//            }
            System.out.println("#" + speed + " DNA is future");
            speed--;
        }
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
        out.writeObject(this); // CODE
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
        in.readObject();
        new Thread(this).start(); // CODE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // CODE
        ByteArrayOutputStream btArr = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(btArr));
        Solution savedObj = new Solution(6);
        savedObj.writeObject(objOut);
        objOut.close();

        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(btArr.toByteArray()));
        Solution loadedObj = (Solution) objIn.readObject();
        objIn.close();

        System.out.println(savedObj.equals(loadedObj)); // false
    }
}
