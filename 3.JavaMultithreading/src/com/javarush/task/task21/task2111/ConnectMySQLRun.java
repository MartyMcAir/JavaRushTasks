package com.javarush.task.task21.task2111;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMySQLRun {
    public static void main(String[] args) throws SQLException {
        String db = "`catalogPuZer2`";   // Имя создаваемой базы данных
        String SQL_createDataBase = "CREATE DATABASE IF NOT EXISTS" + db +
                "DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";

        String SQL_createTable = "CREATE TABLE IF NOT EXISTS `books` (" +
                "  `id` int(11) NOT NULL," +
                "  `name` varchar(50) NOT NULL," +
                "  `author` varchar(50) NOT NULL," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

        String db2 = "`z_test`";
        String SQL_insertInTable = "INSERT INTO " + db2 + ".books (id, `name`, author)" +
                "    VALUES (1, 'Effective Java', 'Joshua Bloch');";

        ConnectionPoolDS cpd = new ConnectionPoolDS();
        try (Connection new_con = cpd.getConnect("z_test");
             Statement stmt = new_con.createStatement()) {
            stmt.executeUpdate(SQL_createDataBase);  // запрос на создание БД
            System.out.println("База данных создана");

            stmt.execute(SQL_createTable);
            System.out.println("таблица создана");


            stmt.executeUpdate(SQL_insertInTable, Statement.RETURN_GENERATED_KEYS);
            System.out.println("таблица обновлена");

            // RETURN_GENERATED_KEYS - делаем запрос на возврат ключа созданной записи
            int index = -1;
            // вызываем метод getGeneratedKeys()-для получения присвоенного индекса при создании записи
            // и присваиваем результат метода объектной rs переменной ResultSet интерфейса
            // для дальнейшей манипуляции с данными
            ResultSet rs = stmt.getGeneratedKeys();
            // rs.next() - возвращает true если результат доступен (т.е. проверяет результат)
            // и перемещает уазатель внутри результатирующего набора
            if (rs.next()) index = rs.getInt(1); // getInt(1) - получаем индекс
            System.out.println("Индекс новой записи: " + index); // выводим индекс записи

        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
