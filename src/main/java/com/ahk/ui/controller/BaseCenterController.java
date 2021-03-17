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
    public TableView<ProductTableModel> productsTV;
    @FXML
    public TableColumn<ProductTableModel, Integer> productsIdTC, productsValTC;
    @FXML
    public TableColumn<ProductTableModel,String> productsNameTC, productsBarcodeTC;
    @FXML
    public TableColumn<ProductTableModel,Float> productsPriceTC;


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

    public void reportButtonAction(){
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("report");
        MainController.publicMainBP.setCenter(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productsTV.setVisible(false);

   /*     Thread thread =
                new Thread(new FillProductTable(
                        this.productsTV
                        ,productsIdTC
                        ,productsValTC
                        ,productsNameTC
                        ,productsBarcodeTC
                        ,productsPriceTC));*/
        Thread thread =
                new Thread(new FillProductTable(
                        this));
        thread.start();

    }
}
