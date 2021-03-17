package com.ahk.ui.controller;

import com.ahk.data.Product;
import com.ahk.data.ProductTableModel;
import com.ahk.ui.db_access.FillProductTable;
import com.ahk.ui.util.SetCenter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BaseCenterController implements Initializable {
    @FXML
    TableView<ProductTableModel> productsTV;
    @FXML
    TableColumn<ProductTableModel, Integer> productsIdTC, productsValTC;
    @FXML
    TableColumn<ProductTableModel,String> productsNameTC, productsBarcodeTC;
    @FXML
    TableColumn<ProductTableModel,Float> productsPriceTC;


    public void saveButtonAction() {
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("save");
        MainController.publicMainBP.setCenter(pane);
    }

    public void updateButtonAction() {
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("update");
        MainController.publicMainBP.setCenter(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productsTV.setVisible(false);

        Thread thread =
                new Thread(new FillProductTable(
                        this.productsTV
                        ,productsIdTC
                        ,productsValTC
                        ,productsNameTC
                        ,productsBarcodeTC
                        ,productsPriceTC));
        thread.start();

    }
}
