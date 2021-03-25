package com.ahk.db.sqlite;

import com.ahk.program.data.Product;
import com.ahk.program.data.Sale;
import com.ahk.program.data.SaleDetails;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetManager {
    public List<Product> resultSetToProducts(ResultSet resultSet) {
        List<Product> products = null;
        try {
            products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(new Product().id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .price(resultSet.getFloat(3))
                        .val(resultSet.getInt(4))
                        .barcode(resultSet.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return products;
        }
    }

    public List<Sale> resultSetToSales(ResultSet resultSet) {
        List<Sale> sales = null;
        try {
            sales = new ArrayList<>();
            while (resultSet.next()) {
                sales.add(new Sale().receiptCount(resultSet.getInt(1))
                        .totalAmount(resultSet.getFloat(2))
                        .cashPayment(resultSet.getFloat(3))
                        .creditPayment(resultSet.getFloat(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return sales;
        }
    }

    public List<SaleDetails> resutSetToSaleDetails(ResultSet resultSet) {
        List<SaleDetails> saleDetails = null;
        try {
            saleDetails = new ArrayList<>();
            while (resultSet.next()) {
                saleDetails.add(new SaleDetails()
                        .productId(resultSet.getInt(1))
                        .productName(resultSet.getString(2))
                        .amount(resultSet.getFloat(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return saleDetails;
        }
    }
}
