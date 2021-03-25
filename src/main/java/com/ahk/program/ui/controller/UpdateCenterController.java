package com.ahk.program.ui.controller;

import com.ahk.program.ui.db_access.FindOneProduct;
import com.ahk.program.ui.db_access.UpdateProduct;
import com.ahk.program.ui.util.SetCenter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCenterController implements Initializable {

    @FXML
    TextArea warningTextArea;
    @FXML
    public TextField nameTextF,idTextF,priceTextF,barcodeTextF;
    @FXML
    public ComboBox <String> valComboBox;
    @FXML
    public RadioButton searchIdRadioB, searchNameRadioB;
    @FXML
    public Button searchButton,cleanButton,updateButton,backButton;

    public void clean(){
        nameTextF.setText("");
        idTextF.setText("");
        priceTextF.setText("");
        priceTextF.setDisable(true);
        barcodeTextF.setText("");
        barcodeTextF.setDisable(true);
        warningTextArea.setText("");
        valComboBox.setVisible(false);
        valComboBox.setValue(null);
        valComboBox.setDisable(true);
        valComboBox.setVisible(true);
        updateButton.setDisable(true);
        searchButton.setDisable(false);
        if(searchIdRadioB.isSelected()){
            idTextF.setDisable(false);
            nameTextF.setDisable(true);
        }else if(searchNameRadioB.isSelected()) {
            idTextF.setDisable(true);
            nameTextF.setDisable(false);
        }
    }

    public void backButtonClicked(){
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("base");
        MainController.publicMainBP.setCenter(pane);
    }

    public void cleanButtonClicked(){
        if(searchIdRadioB.isSelected()) {
            idTextF.setDisable(false);
            nameTextF.setDisable(true);
        }else if (searchNameRadioB.isSelected()){
            nameTextF.setDisable(false);
            idTextF.setDisable(true);
        }
        searchButton.setDisable(false);
        clean();
    }

    public void searchButtonClicked(){
        if(!idTextF.getText().isEmpty()||!nameTextF.getText().isEmpty()){
            Thread thread = new Thread(new FindOneProduct(this));
            thread.start();
        }else {
            warningTextArea.setText("Please set value");
        }
    }

    public void updateButtonClicked(){
        if(valComboBox.getSelectionModel().getSelectedItem()==null||nameTextF.getText().equals("")
                ||idTextF.getText().equals("")||priceTextF.getText().equals("")){
            warningTextArea.setText("Please select item and fill the blanks");
        }else if(!(barcodeTextF.getText().length()==13||barcodeTextF.getText().length()==0)){
            warningTextArea.setText("Please set barcode number as 13 character or don't set");
        }else{
            Thread thread = new Thread(new UpdateProduct(this));
            thread.start();
        }


    }

    public void searchIdRBClicked(){
        clean();
        searchNameRadioB.setSelected(false);
        idTextF.setDisable(false);
        nameTextF.setDisable(true);
        searchButton.setDisable(false);

    }

    public void searchNameRBClicked(){
        clean();
        searchIdRadioB.setSelected(false);
        nameTextF.setDisable(false);
        idTextF.setDisable(true);
        searchButton.setDisable(false);
    }

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
}
