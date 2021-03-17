package com.ahk.ui.db_access;

import com.ahk.data.Product;
import com.ahk.data.ProductTableModel;
import com.ahk.db.sqlite.ProductDBManager;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class FillProductTable implements Runnable {

    public TableView<ProductTableModel> tv;

    public List<ProductTableModel> productTM=null;
    public ObservableList<ProductTableModel> masterData = null;
    TableColumn<ProductTableModel, Integer> productsIdTC;
    TableColumn<ProductTableModel, Integer> productsValTC;
    TableColumn<ProductTableModel, String> productsNameTC;
    TableColumn<ProductTableModel, String> productsBarcodeTC;
    TableColumn<ProductTableModel, Float> productsPriceTC;

    public FillProductTable(TableView<ProductTableModel> tv, TableColumn<ProductTableModel, Integer> productsIdTC
            , TableColumn<ProductTableModel, Integer> productsValTC, TableColumn<ProductTableModel, String> productsNameTC,
                            TableColumn<ProductTableModel, String> productsBarcodeTC,
                            TableColumn<ProductTableModel, Float> productsPriceTC) {
        this.tv = tv;
        this.productsIdTC = productsIdTC;
        this.productsValTC = productsValTC;
        this.productsNameTC = productsNameTC;
        this.productsBarcodeTC = productsBarcodeTC;
        this.productsPriceTC = productsPriceTC;
    }


    @Override
    public void run() {
        try {
            productTM = new ArrayList<>();
            this.productsIdTC.setCellValueFactory(cellData-> {
                IntegerProperty idProperty = cellData.getValue().getIdProperty();
                return idProperty.asObject();
            });
            this.productsNameTC.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
            this.productsPriceTC.setCellValueFactory(cellData -> {
                FloatProperty price = cellData.getValue().getPriceProperty();
                return price.asObject();
            });
            this.productsValTC.setCellValueFactory(cellData-> {
                IntegerProperty val = cellData.getValue().getValProperty();
                return val.asObject();});
            this.productsBarcodeTC.setCellValueFactory(cellData -> cellData.getValue().getBarcodeProperty());

            ProductDBManager manager = new ProductDBManager();
            List<Product> products;
            products = manager.getAllProducts();
            for(Product product:products) {
                productTM.add(
                        new ProductTableModel(product.getId(),
                                product.getName(),
                                product.getPrice(),
                                product.getVal(),
                                product.getBarcode())
                );
            }

            masterData = FXCollections.observableArrayList(productTM);
            tv.getItems().setAll(masterData);
            onSuccess();
        } catch (Exception e) {
            onError(e);
        }
    }

    public void onSuccess() {
        tv.setVisible(true);
    }

    public void onError(Exception e) {
        e.printStackTrace();
    }
}
