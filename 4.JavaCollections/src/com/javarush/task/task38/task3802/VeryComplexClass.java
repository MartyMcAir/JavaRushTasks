package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

public class VeryComplexClass {
    public static void main(String[] args) throws Exception {
//        VeryComplexClass veryComplexClass = new VeryComplexClass();
//        veryComplexClass.veryComplexMethod();
//        InputStream in = new FileInputStream(new File("filename"));
//        FileReader fileReader = new FileReader("filename");
    }

    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
//        int num = 10;
//        int i = num / 0;

//        int[] arrA = new int[2];
//        arrA[2] = 3;

//        char chr = "123".charAt(10);

        new FileInputStream("abcd");
    }

}
