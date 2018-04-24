package com.akaxin.signup_server.Dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteUtil {
    public static boolean flag = true;
    private static Connection connection;

    public static Connection getConnection() {
        initSqlite();
        return connection;
    }

    private static void initSqlite() {
        if (flag) {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                if (new File("SignUp.db").exists()) {
                    c = DriverManager.getConnection("jdbc:sqlite:SignUp.db");
                    connection = c;
                    System.out.println("Opened database successfully");
                    flag = false;
                    return;
                } else {
                    c = DriverManager.getConnection("jdbc:sqlite:SignUp.db");
                    connection = c;
                    System.out.println("Opened database successfully");
                    stmt = c.createStatement();
                    String sql =
                            "create table leader" +
                                    "(" +
                                    "  id          text not null" +
                                    "    primary key," +
                                    "  leader_name text    not null," +
                                    "  phone_num   text not null," +
                                    "  wechat_num  text," +
                                    "  grade       text," +
                                    "  class       text," +
                                    "  create_time DATE    not null" +
                                    ");";
                    stmt.executeUpdate(sql);
                    sql = "create table member" +
                            "(" +
                            "  id          INTEGER not null" +
                            "    primary key," +
                            "  group_id    TEXT    not null," +
                            "  member_name TEXT    not null," +
                            "  phone_num   text not null," +
                            "  wechat_num  text," +
                            "  grade       TEXT," +
                            "  class       TEXT," +
                            "  add_time    DATE    not null" +
                            ");";
                    Statement statement = c.createStatement();
                    statement.executeUpdate(sql);
                    stmt.close();
                    flag = false;

                    System.out.println("Table created successfully");
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
