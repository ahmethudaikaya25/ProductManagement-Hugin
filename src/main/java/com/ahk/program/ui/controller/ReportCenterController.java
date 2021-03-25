package com.ahk.program.ui.controller;

import com.ahk.program.ui.db_access.CreateReport;
import com.ahk.program.ui.util.SetCenter;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;


public class ReportCenterController {
    @FXML
    public TextArea reportTextArea;

    public void backButtonClicked(){
        SetCenter setCenter = new SetCenter();
        Pane pane = setCenter.getPage("base");
        MainController.publicMainBP.setCenter(pane);
    }

    public void getReportButtonClicked(){
        CreateReport report = new CreateReport(this.reportTextArea);
        Thread thread = new Thread(report);
        thread.start();
    }
}
