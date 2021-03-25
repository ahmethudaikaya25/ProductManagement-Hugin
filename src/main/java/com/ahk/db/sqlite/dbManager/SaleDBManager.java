package com.ahk.db.sqlite.dbManager;

import com.ahk.db.sqlite.QueryManager;
import com.ahk.db.sqlite.ResultSetManager;
import com.ahk.program.data.Sale;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.List;

public class SaleDBManager {

    public void save(Sale sale) {
        QueryManager manager = new QueryManager();
        String sql = "";
        List<Sale> sales = getAllSales();
        System.out.println("Sale:"+sale.getReceiptCount());
        if (sales.size() > 0) {
            Integer receiptSum = sale.getReceiptCount()+sales.get(0).getReceiptCount();
            float totalAmountSum = sale.getTotalAmount()+sales.get(0).getTotalAmount();
            float cashPaymentSum = sale.getCashPayment()+sales.get(0).getCashPayment();
            float creditPaymentSum = sale.getCreditPayment()+sales.get(0).getCreditPayment();
            String tASS = new DecimalFormat("#.0#").format(totalAmountSum);
            String cpSS = new DecimalFormat("#.0#").format(creditPaymentSum);
            String caPSS = new DecimalFormat("#.0#").format(cashPaymentSum);


            sql = String.format("update sale set receiptCount="+receiptSum+" , totalAmount="+totalAmountSum+" , cashPayment="+
                    cashPaymentSum+" , creditPayment="+ creditPaymentSum);
            System.out.println(sql);
            manager.updateQuery(sql);
        } else {
            sql = "insert into sale (cashPayment,creditPayment,receiptCount,totalAmount) values (" +
                    sale.getCashPayment() + "," + sale.getCreditPayment() + "," +
                    sale.getReceiptCount()  + "," + sale.getTotalAmount() + ")";
            manager.updateQuery(sql);
        }

    }


    public List<Sale> getAllSales() {
        QueryManager manager = new QueryManager();
        String sql = "select * from sale";
        ResultSet rs = manager.query(sql);
        List<Sale> sales = new ResultSetManager().resultSetToSales(rs);
        return sales;
    }


}
