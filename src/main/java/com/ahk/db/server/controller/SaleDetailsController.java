package com.ahk.db.server.controller;

import com.ahk.db.sqlite.dbManager.SaleDetailsDBManager;
import com.ahk.program.data.SaleDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/saleDetails")
public class SaleDetailsController {

    @PostMapping("/save")
    public Boolean uploadSaleDetails(@RequestBody String body) {
        System.out.println(body);
        Gson gson = new Gson();

        Type type = new TypeToken<List<SaleDetails>>() {
        }.getType();
        List<SaleDetails> saleDetails = gson.fromJson(body, type);
        SaleDetailsDBManager saleDetailsDBManager = new SaleDetailsDBManager();
        for (SaleDetails saleDetails1 : saleDetails) {
            saleDetailsDBManager.save(saleDetails1);
        }
        return true;
    }

}
