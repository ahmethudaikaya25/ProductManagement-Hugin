package com.ahk.db.sqlite;

import com.ahk.data.Product;

import java.sql.ResultSet;
import java.util.List;

public class ProductDBManager {
    public void save(Product product) {
        ProductQueryManager manager = new ProductQueryManager();
        String sql = "insert into products values (" + product.getId() + ",'" + product.getName() + "'," + product.getPrice() + ","
                + product.getVal() + ",'" + product.getBarcode() + "')";
        if(manager.noResponseQuery(sql)){
            System.out.println("id:"+product.getId()+" saved");
        }
    }

    public void updateWithId(Product product) {
        ProductQueryManager manager = new ProductQueryManager();
        String sql = "update products set name='" + product.getName() + "', price=" + product.getPrice() + ",val="
                + product.getVal() + ",barcode='" + product.getBarcode() + "' where id=" + product.getId();
        manager.updateQuery(sql);
    }

    public void updateWithName(Product product) {
        ProductQueryManager manager = new ProductQueryManager();
        String sql = "update products set id=" + product.getId() +", price=" + product.getPrice() + ",val="
                + product.getVal() + ",barcode='" + product.getBarcode() + "' where name='" + product.getName()+"'";
        manager.updateQuery(sql);
    }

    public Product getProductWithId(int id) {
        ProductQueryManager manager = new ProductQueryManager();
        String sql = "select * from products where id= " + id;
        ResultSet rs = manager.query(sql);
        return new ResultSetManager().resultSetToProducts(rs).get(0);
    }

    public Product getProductWithName(String name) {
        ProductQueryManager manager = new ProductQueryManager();
        String sql = "select * from products where name= '" + name+"'";
        ResultSet rs = manager.query(sql);
        return new ResultSetManager().resultSetToProducts(rs).get(0);
    }

    public List<Product> getAllProducts() {
        ProductQueryManager manager = new ProductQueryManager();
        String sql = "select * from products";
        ResultSet rs = manager.query(sql);
        return new ResultSetManager().resultSetToProducts(rs);
    }


}
