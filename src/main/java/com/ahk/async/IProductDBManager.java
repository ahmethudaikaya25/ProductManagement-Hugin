package com.ahk.async;

import java.sql.ResultSet;

public interface IProductDBManager {

    IProductDBManager begin(IProductDBManager manager, String query);

    ResultSet end(IProductDBManager manager);
}
