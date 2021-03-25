package com.ahk.db.server.controller;

import com.ahk.db.sqlite.dbManager.ProductDBManager;
import com.ahk.program.data.Product;
import com.ahk.program.data.ProductForSale;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/getProduct")
    public String getProduct() {
        List<Product> productsAllInfo = new ProductDBManager().getAllProducts();
        ModelMapper modelMapper = new ModelMapper();
        List<ProductForSale> products = new ArrayList<>();
        for (Product productAllInfo : productsAllInfo) {
            products.add(modelMapper.map(productAllInfo, ProductForSale.class));
        }
        Gson gson = new Gson();
        return gson.toJson(products);
    }
}
