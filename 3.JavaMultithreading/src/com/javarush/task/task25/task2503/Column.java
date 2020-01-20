package com.javarush.task.task25.task2503;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    //////////////////
//    public static void configureColumns(Column... newOrder) {
//        realOrder = new int[values().length]; // инициализируется массив values() - final метод enum'a
//        for (Column column : values()) {
//            realOrder[column.ordinal()] = -1; // текущ позиции зачем-то присваивают -1
//            boolean isFound = false;
//
//            // newOrder: Column.Amount, Column.AccountNumber, Column.BankName
//            for (int i = 0; i < newOrder.length; i++) { // перебираем вновь поступившую последоватлеьность
//                if (column == newOrder[i]) { // если найдено совпадение с текущим column
//                    if (isFound) { // выбрасываем исключение, если это совпадениею уже было
//                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
//                    }
//                    realOrder[column.ordinal()] = i; // иначе realOrder массиву присваиваем i
//                    // мол таким образом запоминаем нов последовательность!?, храня её в int[] array..
//                    isFound = true;
//                }
//            }
//        }
//    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        // 1) Заполнить список четырьмя null.
        //2) Если realOrder[i] != -1, вставить в нужное место (через result.set()) нужную колонку.
        //3) Удалить все null: result.removeAll(Collections.singleton(null));
        // Тогда все сдвинется как надо (в том числе для метода hide()).
//        for (int i = 0; i < 4; i++) {
//            result.add(null);
//        }
//        for (int i = 0; i < realOrder.length; i++) {
//            if (realOrder[i] != -1) {
//                result.set(i, values()[i]);
//            }
//        }
//        result.removeAll(Collections.singleton(null));

        //OR // зачем-то дублируется при выводе
//        for (int i = 0; i < realOrder.length ; i++) {
//            if(realOrder[i] != -1)
//                result.add(Column.values()[i]);
//        }
//        result.sort((column, t1) -> (realOrder[column.ordinal()] >= realOrder[t1.ordinal()])? 1: -1);

        // OR _ // наверно не полное решение
//        Collections.sort(result, Comparator.comparing(column -> realOrder[column.ordinal()]));

        // My
        for (int i = 0; i < realOrder.length; i++) {
            int newOrder = realOrder[i];
            if (newOrder != -1) { // если индекс не скрыт
                result.add(Column.values()[i]);
//                result.add(Column.values()[newOrder]); // here was my fail
            }
        }
        result.sort((column, t1) -> (realOrder[column.ordinal()] >= realOrder[t1.ordinal()]) ? 1 : -1);

        return result;
    }

    public static int[] getRealOrder() {
        return realOrder;
    }

    //////////////
    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public boolean isShown() {
//        String name = this.getColumnName();
//        List<Column> list = getVisibleColumns();
//        for (Column item : list) {
//            if (item.getColumnName().equals(name)) {
//                return true;
//            }
//        }
        // без вычислений берем сразу из метода ordinal()
        if (realOrder[ordinal()] == -1) {
            return false;
        }
        return true;
    }

    @Override
    public void hide() {
//        String name = this.getColumnName();
//        int indexName = 0;
        // вычисляем искомый индекс в Original последовательности _ wrong way
//        for (int i = 0; i < values().length; i++) {
//            if (values()[i].getColumnName().equals(name)) {
//                indexName = i;
//            }
//        }

        // вычисляем индекс в новой realOrder последовательности - rightWay
//        List<Column> list = getVisibleColumns();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getColumnName().equals(name)) {
//                indexName = i;
//            }
//        }
//        for (int i = 0; i < realOrder.length; i++) {
//            if (i == indexName) {
//                realOrder[i] = -1; // присваваем -1, тому что надо скрыть
//            }
//        }
        // без вычислений сразу берем индекс из метода ordinal()
        realOrder[ordinal()] = -1;
    }
}
