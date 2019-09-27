package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add(bf.readLine());
        }
//        System.out.println(list.toString()); // [1, 2, 3, 4, 5]
        list.remove(2); // 0 1 2
//        System.out.println(list.toString()); // [1, 2, 4, 5]

        Collections.sort(list, Collections.reverseOrder());

        for (String st : list) { // валидацию проходит
            System.out.println(st); // // 5 4 2
        }

        // работает но валидацию не проходит
//        for(int i=3; i>0; i--){
////        for(int i=0; i<3; i++){ // 1 2 4
//            System.out.println(list.get(i)); // 5 4 2
//        }
    }
}


