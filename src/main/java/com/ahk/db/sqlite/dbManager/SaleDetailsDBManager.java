package com.ahk.db.sqlite.dbManager;

import com.ahk.db.sqlite.QueryManager;
import com.ahk.db.sqlite.ResultSetManager;
import com.ahk.program.data.Product;
import com.ahk.program.data.SaleDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SaleDetailsDBManager {

    public Boolean saveAll(List<SaleDetails> saleDetails) {
        QueryManager manager = new QueryManager();
        String sql = "insert into saleDetails values ";
        for (SaleDetails saleDetail : saleDetails) {
            sql = sql + "(" +
                    saleDetail.getProductId() + ",'" +
                    saleDetail.getProductName() + "'," +
                    saleDetail.getAmount() + "),";
        }
        sql = sql.substring(0, sql.length() - 1);
        return manager.noResponseQuery(sql);

    }

    public Boolean save(SaleDetails saleDetails) {
        QueryManager manager = new QueryManager();
        String sql = "";
        List<SaleDetails> saleDetails1 = getWithName(saleDetails.getProductName());
        Float sum = saleDetails.getAmount()+saleDetails1.get(0).getAmount();
        if (saleDetails1.size()>0) {
            sql = "update saleDetails set amount ="+sum+
                    " where name='"+saleDetails1.get(0).getProductName()+"'";


        }else {
            ProductDBManager productDBManager = new ProductDBManager();
            Product product=productDBManager.getProductWithName(saleDetails.getProductName());


            sql = "insert into saleDetails values (" +
                    product.getId() + ",'"
                    + saleDetails.getProductName() + "',"
                    + saleDetails.getAmount() + ")";
        }

        return manager.noResponseQuery(sql);
    }


    public List<SaleDetails> getAllSaleDetails() {
        QueryManager manager = new QueryManager();
        String sql = "select * from saleDetails";
        ResultSet rs = manager.query(sql);
        List<SaleDetails> saleDetails = new ResultSetManager().resutSetToSaleDetails(rs);
        return saleDetails;
    }

    public List<SaleDetails> getWithName(String name) {
        QueryManager queryManager = new QueryManager();
        String sql = "select * from saleDetails where name='" + name + "'";
        ResultSet rs = queryManager.query(sql);
        List<SaleDetails> saleDetails = new ResultSetManager().resutSetToSaleDetails(rs);
        return saleDetails;
    }


}
