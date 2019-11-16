package com.javarush.task.task19.task1928;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* 
Исправить ошибку. Классы и интерфейсы
*/

public class Solution {
    {
        System.out.println("This is the Solution class");
    }

    public static void main(String... args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(myPath()[0]);
//                FileOutputStream outputStream = new FileOutputStream(args[0]);
                // тут можно написать скажем text.txt _ и кинуть в директорию с исполняемым java файлом
                InputStream is = Solution.class.getClassLoader().getResourceAsStream("");
//                InputStream is = Solution.class.getClassLoader().getResourceAsStream(myPath()[1]);
//                InputStream is = Solution.class.getClassLoader().getResourceAsStream(args[1]);
        ) {
            // ;
            byte[] b = new byte[is.available()];
            is.read(b);   // code
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            if (result instanceof C) {
//            if (result instanceof A) {
//                A p = (C) result;
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("This is the A class");
        }
    }

    class B implements Example {
        {
            System.out.println("This is the B class");
        }
    }

    class C extends A {
        {
            System.out.println("This is the C class");
        }
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }
}
