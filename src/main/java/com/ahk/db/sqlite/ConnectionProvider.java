package com.ahk.db.sqlite;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionProvider {
    private static Connection conn;

    public static Connection getInstance() {
        if (conn == null) {
            try {
                if(!new File("./db/hugin.db").exists()){
                    Path path = Paths.get("./db/");
                    Files.createDirectories(path);
                }
                String url = "jdbc:sqlite:./db/hugin.db";
                conn = DriverManager.getConnection(url);
                String sql = "CREATE TABLE IF NOT EXISTS products (\n"
                        + "	id integer PRIMARY KEY,\n"
                        + "	name text(20) UNIQUE,\n"
                        + "	price double,\n"
                        + " val integer,\n"
                        + " barcode text(20)\n"
                        + ");";
                Statement statement = conn.createStatement();
                statement.execute(sql);
                System.out.println("established db");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("returned conn");
                return conn;
            }
        } else {
            System.out.println("returned conn2");
            return conn;
        }
    }
}