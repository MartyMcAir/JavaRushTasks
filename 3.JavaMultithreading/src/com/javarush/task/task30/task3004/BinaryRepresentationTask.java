package com.javarush.task.task30.task3004;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private final int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }
    // как я понял..
    // необходимо провести декомпозицию функционала в методе binaryRepresentationMethod(..), в метод run()

    // скопировал метод и заменил 1 строчку
    //return binaryRepresentationMethod(b) + result;
    //
    // на 2 строчки с созданием объекта таска с последующим fork и возвратом join
    //
    //скорость выполнения обычной рекурсии по сравнению с fork/join
    //105880ns и 10672306ns
    //~ 100 раз

    @Override
    protected String compute() {
//        BinaryRepresentationTask task = new BinaryRepresentationTask(x);
//        task.fork().complete(BigInteger.valueOf(x).toString(2));
//        return task.join(); // 110

        // Original default example ___ OR
        // то как должно вычитывать _ и этого следуетпровести декомпозицию
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
//            task.fork().complete(String.valueOf(task + result)); // неверное решение
            task.fork();
            return task.join() + result;
        }
        return result; // join() - а тут не то возврщал join() вместо result
    }
}
