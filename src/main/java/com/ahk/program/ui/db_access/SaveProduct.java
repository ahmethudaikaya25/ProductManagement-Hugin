package com.ahk.program.ui.db_access;

import com.ahk.program.data.Product;
import com.ahk.db.sqlite.dbManager.ProductDBManager;
import com.ahk.program.ui.controller.SaveCenterController;
import com.ahk.program.ui.util.AlertManager;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class SaveProduct implements Runnable, AsyncDBAccess {

    private Product product;

    private SaveCenterController controller;
    public SaveProduct(Product product, SaveCenterController controller) {
        this.product = product;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            ProductDBManager manager = new ProductDBManager();
            Boolean b = manager.save(this.product);
            if (b) {
                onSuccess();
            }else {
                Platform.runLater(()->new AlertManager().title("Save").message("This product is exist").showInformation());
            }
        }catch (Exception e){
            onError(e);
        }
    }


    @Override
    public void onSuccess() {
        Platform.runLater(()->controller.clear());
        Platform.runLater(()->new AlertManager().title("Save").message("This product is saved").showInformation());
    }

    @Override
    public void onError(Exception e) {
        Platform.runLater(()->new AlertManager().alertType(Alert.AlertType.ERROR).title("Save").header("Save error")
                .message(e.getMessage()).showInformation());
    }
}
