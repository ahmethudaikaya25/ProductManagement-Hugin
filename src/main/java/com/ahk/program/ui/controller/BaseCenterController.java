package com.ahk.program.ui.controller;

import com.ahk.program.ui.util.ProductTableModel;
import com.ahk.program.ui.db_access.FillProductTable;
import com.ahk.program.ui.util.SetCenter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseCenterController implements Initializable {
    @FXML
    public TableView<ProductTableModel> productsTV;
    @FXML
    public TableColumn<ProductTableModel, Integer> productsIdTC, productsValTC;
    @FXML
    public TableColumn<ProductTableModel, String> productsNameTC, productsBarcodeTC;
    @FXML
    public TableColumn<ProductTableModel, Float> productsPriceTC;
    @FXML
    public Button closeButton;


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

    public void reportButtonAction() {
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("report");
        MainController.publicMainBP.setCenter(pane);
    }

    public void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Thread thread =
                new Thread(new FillProductTable(
                        this));
        thread.start();
    }
}
