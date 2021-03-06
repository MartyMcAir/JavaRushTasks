package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        //
//        while (t2.isAlive()){
//        }
        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        // достаточно 3х переменных и join() в нужном месте, всё.
        String a, b, c, result = "";
//        public Read3Strings(){
//            start();
//        }

        @Override
        public void run() {
            try {
//                while (!reader.ready()) {
//                for (int i = 0; i < 3; i++) {
//                    result += reader.readLine() + " ";
//                }
                    a = reader.readLine();
                    b = reader.readLine();
                    c = reader.readLine();
//                    result = a + " " + b + " " + c;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void printResult() {
            System.out.println(a + " " + b + " " + c);
//            System.out.println(result);
        }
    }
}
