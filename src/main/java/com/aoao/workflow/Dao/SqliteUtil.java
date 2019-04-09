package com.aoao.workflow.Dao;

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
                if (new File("workFlow.db").exists()) {
                    c = DriverManager.getConnection("jdbc:sqlite:workFlow.db");
                    connection = c;
                    System.out.println("Opened database successfully");
                    flag = false;
                    return;
                } else {
                    c = DriverManager.getConnection("jdbc:sqlite:workFlow.db");
                    connection = c;
                    System.out.println("Opened database successfully");
                    String sql = "CREATE TABLE worker (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "name TEXT(4) NOT NULL," +
                            "status INTEGER NOT NULL," +
                            "jobid INTEGER," +
                            "CONSTRAINT jobid FOREIGN KEY (jobid) REFERENCES job (id)" +
                            ");";
                    Statement statement1 = c.createStatement();
                    statement1.executeUpdate(sql);
                    statement1.close();

                    sql = "CREATE TABLE job (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "jobName TEXT(10) NOT NULL," +
                            "level INTEGER," +
                            "CONSTRAINT level UNIQUE (level ASC)" +
                            ");";
                    Statement statement2 = c.createStatement();
                    statement2.executeUpdate(sql);
                    statement2.close();

                    sql = "CREATE TABLE apply (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "worker_id INTEGER NOT NULL," +
                            "reason TEXT," +
                            "status INTEGER," +
                            "applyType INTEGER NOT NULL," +
                            "createTime INTEGER NOT NULL," +
                            "CONSTRAINT wokerID FOREIGN KEY (worker_id) REFERENCES worker (id)" +
                            ");";
                    Statement statement3 = c.createStatement();
                    statement3.executeUpdate(sql);
                    statement3.close();
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
