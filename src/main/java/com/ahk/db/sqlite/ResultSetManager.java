package com.ahk.db.sqlite;

import com.ahk.data.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetManager {
    public List<Product> resultSetToProducts(ResultSet resultSet) {
        List<Product> products = null;
        try {
            products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(new Product().id(resultSet.getInt(1)).name(resultSet.getString(2))
                        .price(resultSet.getFloat(3)).val(resultSet.getInt(4)).barcode(resultSet.getString(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return products;
        }
    }
}
