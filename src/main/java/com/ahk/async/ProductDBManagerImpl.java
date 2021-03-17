package com.ahk.async;

import java.sql.ResultSet;

public class ProductDBManagerImpl implements IProductDBManager {
    
    @Override
    public IProductDBManager begin(IProductDBManager manager, String query) {
        return null;
    }

    @Override
    public ResultSet end(IProductDBManager manager) {
        return null;
    }
}
