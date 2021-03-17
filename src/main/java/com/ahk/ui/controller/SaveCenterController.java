package com.ahk.ui.controller;

import com.ahk.data.Product;
import com.ahk.ui.db_access.SaveProduct;
import com.ahk.ui.util.SetCenter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SaveCenterController implements Initializable {
    @FXML
    ComboBox <String> valComboBox;
    @FXML
    TextField nameTextF;
    @FXML
    TextField idTextF;
    @FXML
    TextField priceTextF;
    @FXML
    TextField barcodeTextF;
    @FXML
    TextArea warningTextArea;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valComboBox.getItems().addAll("0","1","8","18");
        priceTextF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,5}([\\.]\\d{0,2})?")) {
                priceTextF.setText(oldValue);
                warningTextArea.setText("edit price text");
            }
        });
        idTextF.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\d{0,4}([0-9])?")){
                idTextF.setText(oldValue);
            }
        }));
        barcodeTextF.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\w{0,13}?")){
                barcodeTextF.setText(oldValue);
            }
        }));
        nameTextF.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\w{0,20}?")){
                nameTextF.setText(oldValue);
            }
        }));
    }


    public void saveButtonClicked(){
        System.out.println(valComboBox.getSelectionModel().getSelectedItem());
        if(valComboBox.getSelectionModel().getSelectedItem()==null||nameTextF.getText().equals("")
                ||idTextF.getText().equals("")||priceTextF.getText().equals("")){
            warningTextArea.setText("Please select item and fill the blanks");
        }else if(!(barcodeTextF.getText().length()==13||barcodeTextF.getText().length()==0)){
            warningTextArea.setText("Please set barcode number as 13 character or don't set");
        }else{
            Product product = new Product();
            product.id(Integer.parseInt(idTextF.getText())).name(nameTextF.getText()).price(Float.parseFloat(priceTextF.getText()))
                    .val(Integer.parseInt(valComboBox.getSelectionModel().getSelectedItem())).barcode(barcodeTextF.getText());
            Thread thread = new Thread(new SaveProduct(product));
            thread.start();
        }
    }

    public void backButtonClicked(){
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("base");
        MainController.publicMainBP.setCenter(pane);
    }

}
