package com.ahk.db.sqlite.dbManager;

import com.ahk.db.sqlite.QueryManager;
import com.ahk.db.sqlite.ResultSetManager;
import com.ahk.program.data.Product;

import java.sql.ResultSet;
import java.util.List;

public class ProductDBManager {
    public Boolean save(Product product) {
        QueryManager manager = new QueryManager();
        String sql = "insert into products values (" + product.getId() + ",'" + product.getName() + "'," + product.getPrice() + ","
                + product.getVal() + ",'" + product.getBarcode() + "')";
        return manager.noResponseQuery(sql);
    }

    public void updateWithId(Product product) {
        QueryManager manager = new QueryManager();
        String sql = "update products set name='" + product.getName() + "', price=" + product.getPrice() + ",val="
                + product.getVal() + ",barcode='" + product.getBarcode() + "' where id=" + product.getId();
        manager.updateQuery(sql);
    }

    public void updateWithName(Product product) {
        QueryManager manager = new QueryManager();
        String sql = "update products set id=" + product.getId() + ", price=" + product.getPrice() + ",val="
                + product.getVal() + ",barcode='" + product.getBarcode() + "' where name='" + product.getName() + "'";
        manager.updateQuery(sql);
    }

    public Product getProductWithId(int id) {
        QueryManager manager = new QueryManager();
        String sql = "select * from products where id= " + id;
        ResultSet rs = manager.query(sql);
        List<Product> products = new ResultSetManager().resultSetToProducts(rs);
        if (products.size() > 0) {
            return products.get(0);
        } else {
            return null;
        }
    }

    public Product getProductWithName(String name) {
        QueryManager manager = new QueryManager();
        String sql = "select * from products where name= '" + name + "'";
        ResultSet rs = manager.query(sql);
        List<Product> products = new ResultSetManager().resultSetToProducts(rs);
        if (products.size() > 0) {
            return products.get(0);
        } else {
            return null;
        }
    }

    public List<Product> getAllProducts() {
        QueryManager manager = new QueryManager();
        String sql = "select * from products";
        ResultSet rs = manager.query(sql);
        List<Product> products = new ResultSetManager().resultSetToProducts(rs);
        return products;
    }


}
