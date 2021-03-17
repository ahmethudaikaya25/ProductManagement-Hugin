package com.ahk.db.sqlite;

import com.ahk.data.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductQueryManager {

    public ResultSet query(String query) {
        ResultSet rs = null;
        try {
            Connection connection = ConnectionProvider.getInstance();
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return rs;
        }
    }

    public Boolean nonQuery(String query) {
        boolean success = false;
        try {
            Connection connection = ConnectionProvider.getInstance();
            Statement statement = connection.createStatement();
            success = statement.execute(query);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return success;
        }
    }

    public void updateQuery(String query){
        try {
            Connection connection = ConnectionProvider.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
