package com.javarush.task.task16.task1606;

import java.util.ArrayList;
import java.util.List;

/* 
join: в нужное время в нужном месте
*/

// Нужно всегда учитывать main как первую нить. И знать если в main ты вызвал метод join() у какого то объекта, то сперва
//        выполниться этот обьект, потом запуститься main и будет дальше выполнять свои строки.

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        PrintListThread firstThread = new PrintListThread("firstThread");
        PrintListThread secondThread = new PrintListThread("secondThread");
        firstThread.start();
        firstThread.join();
        secondThread.start();
//        secondThread.join();
    }

    public static void printList(List<String> list, String threadName) {
        for (String item : list) {
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }

    public static List<String> getList(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 1) return result;

        for (int i = 0; i < n; i++) {
            result.add(String.format("String %d", (i + 1)));
        }
        return result;
    }

    public static class PrintListThread extends Thread {
        public PrintListThread(String name) {
            super(name);
        }

        public void run() {
            printList(getList(20), getName());
        }
    }
}