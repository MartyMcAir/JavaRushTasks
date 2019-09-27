package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
//        String result = " ";  // s+s+s+s+s;
        //напишите тут ваш код
        return s+s+s+s+s;
    }

    public static String multiply(String s, int count) {
        String result = "", tmp;
        //напишите тут ваш код
        String [] arrStr = new String[count];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count;i++){
//            tmp = s;
//            result=tmp+s;  // don't work
//            result=s.concat(s);  // don't work _ +tmp too

//            String st = new String(s);
//            result= st+s; // don't work

//            arrStr[i]=s;
//            result = String.join("", arrStr); // work

//            result = sb.append(s).toString();  // work
            result =result +s; // work = result +=s
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(StringHelper.multiply("abc|", 6));
    }
}
