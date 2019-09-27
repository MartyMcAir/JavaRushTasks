package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int i=0, n = Integer.parseInt(bf.readLine());

        while(i<n){
            System.out.println(str);
            i++;
        }
    }
}
