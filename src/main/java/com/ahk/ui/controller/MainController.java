package com.ahk.ui.controller;

import com.ahk.ui.util.SetCenter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public static BorderPane publicMainBP;
    @FXML
    private BorderPane mainBorderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("base");
        mainBorderPane.setCenter(pane);
        publicMainBP = mainBorderPane;
    }
}
