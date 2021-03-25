package com.ahk.program.ui.controller;

import com.ahk.db.server.SpringInitializr;
import com.ahk.program.ui.starter.Main;
import com.ahk.program.ui.util.AlertManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartCenterController {

    @FXML
    Button closeButton;

    public void buttonStartServerClicked(){
        try{

        }catch (Exception e){
            new AlertManager().alertType(Alert.AlertType.ERROR).title("Server").message("Server couldn't started");
        }
    }

    public void buttonCloseClicked(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
