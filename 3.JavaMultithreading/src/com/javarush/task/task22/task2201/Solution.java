package com.javarush.task.task22.task2201;

/*
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();   // STEP1 запускаем Solution
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();   // STEP2 инициализируем наши Threads _ variables
    }

    protected void initThreads() {
        // в Task передается текущий Solution, и строка, потом имя потока
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");
        // чтобы сделать возможным обработку runtime исключений,
        // отправляем класс реализовавший интерфейс UncaughtExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());
        // стартуем наши потоки
        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }
    // synchronized метод _ с блокировкой доступен только для одного потока - пока не освободится
    public synchronized String getPartOfString(String string, String threadName) {
        if (string == null) {
            if (threadName.equals(FIRST_THREAD_NAME)) {
                throw new StringForFirstThreadTooShortException();
            } else if (threadName.equals(SECOND_THREAD_NAME)) {
                throw new StringForSecondThreadTooShortException();
            } else {
                throw new RuntimeException();
            }
        }
        return null;
    }
}
