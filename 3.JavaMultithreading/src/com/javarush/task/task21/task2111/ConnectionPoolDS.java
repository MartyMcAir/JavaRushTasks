package com.javarush.task.task21.task2111;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolDS {
    private Connection cn;

    public MysqlDataSource setMysql(String dbName) throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setPort(3310);
        ds.setUser("test_user");
        ds.setPassword("123689");
//        ds.setDatabaseName("z_test");
        ds.setDatabaseName(dbName);
        ds.setCharacterEncoding("utf8");
        ds.setServerTimezone("UTC");
        ds.setVerifyServerCertificate(false);
        ds.setUseSSL(false);
        ds.setAutoReconnect(true);
        return ds;
    }

    public Connection getConnect() throws SQLException {
        cn = setMysql("z_test").getConnection(); // DB по умолчанию
        return cn;
    }

    public Connection getConnect(String dbName) throws SQLException {
        cn = setMysql(dbName).getConnection();
        return cn;
    }

    public void Disconnect() throws SQLException {
        cn.close();
    }
}
