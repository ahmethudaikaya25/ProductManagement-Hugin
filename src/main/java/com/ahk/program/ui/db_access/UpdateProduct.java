package com.ahk.program.ui.db_access;

import com.ahk.program.data.Product;
import com.ahk.db.sqlite.dbManager.ProductDBManager;
import com.ahk.program.ui.controller.UpdateCenterController;
import com.ahk.program.ui.util.AlertManager;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class UpdateProduct implements Runnable,AsyncDBAccess {
    private UpdateCenterController controller;
    private Product product;

    public UpdateProduct(UpdateCenterController controller) {
        this.controller = controller;
        product = new Product();
        product.id(Integer.parseInt(controller.idTextF
                .getText())).name(controller.nameTextF.getText())
                .price(Float.parseFloat(controller.priceTextF.getText()))
                .val(Integer.parseInt(controller.valComboBox.getSelectionModel().getSelectedItem()))
                .barcode(controller.barcodeTextF.getText());
    }

    @Override
    public void run() {
        try {
            ProductDBManager dbManager = new ProductDBManager();
            if (controller.searchIdRadioB.isSelected()) {
                dbManager.updateWithId(product);
            } else if (controller.searchNameRadioB.isSelected()) {
                dbManager.updateWithName(product);
            }
            Platform.runLater(this::onSuccess);
        } catch (Exception e) {
            Platform.runLater(()->onError(e));
        } finally {
            Platform.runLater(() -> controller.clean());
        }
    }

    @Override
    public void onSuccess() {
        new AlertManager().title("Update").message("Update success").showInformation();
    }

    @Override
    public void onError(Exception e) {
        new AlertManager().alertType(Alert.AlertType.ERROR).title("Update").header("Update Error")
                .message(e.getMessage());
    }
}
