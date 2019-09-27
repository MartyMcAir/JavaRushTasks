package com.javarush.task.task07.task0707;

import java.util.ArrayList;
import java.util.Collections;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "one", "two", "three", "four");
        list.add("five");
        int length = list.size();
        System.out.println(length);

        for(int i=0; i<length; i++){
            System.out.println(list.get(i));
        }
    }
}
