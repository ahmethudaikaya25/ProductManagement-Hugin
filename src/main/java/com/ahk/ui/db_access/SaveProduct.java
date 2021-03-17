package com.ahk.ui.db_access;

import com.ahk.data.Product;
import com.ahk.db.sqlite.ProductDBManager;

public class SaveProduct implements Runnable {

    private Product product;

    public SaveProduct(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        ProductDBManager manager = new ProductDBManager();
        manager.save(this.product);
    }
}
