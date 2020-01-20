package com.javarush.task.task25.task2508;

import java.util.Map;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
//        Thread current = Thread.currentThread();
//        System.out.println(thread.isInterrupted());
//        while (!thread.isInterrupted()) {
        while (true) {
            try {
                //  каждые 100 миллисекунд выводить имя исполняемой нити в консоль
                System.out.println(thread.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
//                e.printStackTrace();
            }
        }
    }

    @Override
    public void start(String threadName) {
        // создавать, сохранять во внутреннее поле и запускать нить с именем,
        // которое передано через аргумент метода.
//        System.out.println(threadName);

        // V2
        thread = new Thread(this, threadName);
//        thread.setName(threadName);
        thread.start();

        // получив полный стек всех нитей, запускаем требуюмую _ Version1
//        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
//        for (Map.Entry<Thread, StackTraceElement[]> item : allStackTraces.entrySet()) {
//            Thread keyThread = item.getKey();
//            if (keyThread.getName().equals(threadName)) {
//                this.thread = keyThread;
//                keyThread.start();
//            }
//        }
    }

    @Override
    public void stop() {
        // прерывать последнюю созданную классом TaskManipulator нить.
//        if (thread != null) {
//            System.out.println("ffffffffffffff");
        // this _ т.е. текущая значит последняя
            thread.interrupt();
//        }
    }
}
