package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name = bf.readLine();
        int n3 = Integer.parseInt(bf.readLine());
        int n2 = Integer.parseInt(bf.readLine());
        int n1 = Integer.parseInt(bf.readLine());

        Calendar cal = Calendar.getInstance();
        cal.set(n3, (n2-1), n1); // y m d
        SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");
        System.out.println("Меня зовут "+name+".");
        System.out.println("Я родился "+sdf.format(cal.getTime()));
    }
}
