package com.ahk.db.server.controller;

import com.ahk.db.sqlite.dbManager.SaleDBManager;
import com.ahk.program.data.Sale;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @PostMapping("/save")
    public Boolean save(@RequestBody String body) {
        System.out.println(body);
        body = body.substring(1,body.length()-1);
        Gson gson = new Gson();
        Sale sale = gson.fromJson(body, Sale.class);

        System.out.println(sale.toString());

        SaleDBManager saleDBManager = new SaleDBManager();
        saleDBManager.save(sale);
        return true;
    }
}
