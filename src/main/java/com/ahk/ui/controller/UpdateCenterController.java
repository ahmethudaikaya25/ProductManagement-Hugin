package com.ahk.ui.controller;

import com.ahk.ui.util.SetCenter;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class UpdateCenterController {

    @FXML
    TextArea warningTextArea;
    @FXML
    TextField nameTextF,idTextF,priceTextF,barcodeTextF;
    @FXML
    ComboBox <String> valComboBox;
    @FXML
    RadioButton searchIdComboB,searchNameComboB;
    @FXML
    Button searchButton,cleanButton,updateButton,backButton;

    public void backButtonClicked(){
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("base");
        MainController.publicMainBP.setCenter(pane);
    }

    public void cleanButtonClicked(){
        if(searchIdComboB.isSelected()) {
            idTextF.setDisable(false);
            nameTextF.setDisable(true);
        }else if (searchNameComboB.isSelected()){
            nameTextF.setDisable(false);
            idTextF.setDisable(true);
        }
        nameTextF.setText("");
        idTextF.setText("");
        priceTextF.setText("");
        priceTextF.setDisable(true);
        barcodeTextF.setText("");
        barcodeTextF.setDisable(true);
        warningTextArea.setText("");
        valComboBox.getSelectionModel().select(-1);
        valComboBox.setDisable(true);
        updateButton.setDisable(true);
    }

    public void searchButtonClicked(){
        if(searchIdComboB.isSelected()) {

        }else if (searchNameComboB.isSelected()){

        }
    }

    public void updateButtonClicked(){

    }

    public void searchIdCBClicked(){
        searchNameComboB.setSelected(false);
        idTextF.setDisable(false);
        nameTextF.setDisable(true);
    }

    public void searchNameCBClicked(){
        searchIdComboB.setSelected(false);
        nameTextF.setDisable(false);
        idTextF.setDisable(true);
    }

}
