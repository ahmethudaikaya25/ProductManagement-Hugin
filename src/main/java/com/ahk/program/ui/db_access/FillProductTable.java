package com.ahk.program.ui.db_access;

import com.ahk.program.data.Product;
import com.ahk.program.ui.util.ProductTableModel;
import com.ahk.db.sqlite.dbManager.ProductDBManager;
import com.ahk.program.ui.controller.BaseCenterController;
import com.ahk.program.ui.util.AlertManager;
import javafx.application.Platform;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
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

    public FillProductTable(BaseCenterController base) {
        this.tv = base.productsTV;
        this.productsIdTC = base.productsIdTC;
        this.productsValTC = base.productsValTC;
        this.productsNameTC = base.productsNameTC;
        this.productsBarcodeTC = base.productsBarcodeTC;
        this.productsPriceTC = base.productsPriceTC;
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
            Platform.runLater(()->onError(e));
        }
    }

    public void onSuccess() {

    }

    public void onError(Exception e) {
        new AlertManager().alertType(Alert.AlertType.ERROR).title("Main").header("Table couldn't fill")
                .message(e.getMessage());
    }
}
