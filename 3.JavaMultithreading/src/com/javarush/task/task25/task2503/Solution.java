package com.javarush.task.task25.task2503;

import java.util.Arrays;

/*
Свой enum
*/
public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {
        // если reverse последовательность, т.е. наоборот
        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName, Column.Customer);
        // а текущ последовательность Customer, BankName, AccountNumber, Amount
//        System.out.println(Arrays.toString(Column.getRealOrder())); // [3, 2, 1, 0]
//        // здесь же если Customer убрать то 3 заменится на -1
//
//        // если последоватлеьность, точь в точь
//        // т.е. 0 индексу массива соответств 0 значение, 1нице значение=1 и т.д.
//        Column.configureColumns(Column.Customer, Column.BankName, Column.AccountNumber, Column.Amount);
//        System.out.println(Arrays.toString(Column.getRealOrder())); // [0, 1, 2, 3]
//
//        // если посл совпадени удалено, то -1 в конце массива
//        Column.configureColumns(Column.Customer, Column.BankName, Column.AccountNumber);
//        System.out.println(Arrays.toString(Column.getRealOrder())); // [0, 1, 2, -1]
//
//        // если перв совпадени удалено, то -1 в начале массива
//        Column.configureColumns(Column.BankName, Column.AccountNumber, Column.Amount);
//        System.out.println(Arrays.toString(Column.getRealOrder())); // [-1, 0, 1, 2]

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
        System.out.println(Arrays.toString(Column.getRealOrder())); // [[3, 2, 1, 0]
        Column.AccountNumber.hide();
        System.out.println(Arrays.toString(Column.getRealOrder())); // [-1, 2, 1, 0]

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("AccountNumber.isShown(): " + Column.AccountNumber.isShown());
        System.out.println("Amount.isShown(): " + Column.Amount.isShown());
    }
}
