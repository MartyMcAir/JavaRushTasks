package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listMain = new ArrayList<Integer>();
        ArrayList<Integer> list_on3 = new ArrayList<Integer>();
        ArrayList<Integer> list_on2 = new ArrayList<Integer>();
        ArrayList<Integer> list_oth = new ArrayList<Integer>();

        for(int i=0; i<20; i++){
            listMain.add(sc.nextInt());
        }

        for(int n : listMain){
            if((n%3)==0){
                list_on3.add(n);
            }
            if((n%2)==0){
                list_on2.add(n);
            } else if((n%2)!=0 && (n%3)!=0){
                list_oth.add(n);
            }
        }

//        for(int n : listMain){
//            if((n%3)==0){
//                list_on3.add(n);
//            }
//        }
//
//        for(int n : listMain){
//            if((n%2)==0){
//                list_on2.add(n);
//            }
//        }
//
//        for(int n : listMain){
//            if((n%2)!=0 && (n%3)!=0){
//                list_oth.add(n);
//            }
//        }

        printList(list_on3);
        printList(list_on2);
        printList(list_oth);

    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for(int n : list){
            System.out.println(n);
        }
    }
}
