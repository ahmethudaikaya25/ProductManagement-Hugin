package com.ahk.db.sqlite;

import com.ahk.db.sqlite.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryManager {

    public ResultSet query(String query) {
        ResultSet rs = null;
        try {
            Connection connection = ConnectionProvider.getInstance();
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            return rs;
        }
    }

    public Boolean noResponseQuery(String query) {
        boolean success = false;
        try {
            Connection connection = ConnectionProvider.getInstance();
            Statement statement = connection.createStatement();
            statement.execute(query);
            return true ;

        } catch (Exception e) {
            return false;
        }
    }

    public void updateQuery(String query) {
        try {
            Connection connection = ConnectionProvider.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
