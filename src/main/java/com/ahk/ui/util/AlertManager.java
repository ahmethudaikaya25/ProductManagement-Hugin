package com.ahk.ui.util;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class AlertManager {

    private String message,title,header;
    private AlertType alertType;

    public AlertManager showInformation(){
        if (alertType == null)
            alertType = AlertType.INFORMATION;

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
        return this;
    }

    public AlertType getAlertType(){
        return alertType;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getHeader() {
        return header;
    }

    public AlertManager alertType(AlertType alertType){
        this.alertType = alertType;
        return this;
    }

    public AlertManager title(String title) {
        this.title = title;
        return this;
    }

    public AlertManager header(String header) {
        this.header = header;
        return this;
    }

    public AlertManager message(String message) {
        this.message = message;
        return this;
    }

}
