package com.ahk.ui.db_access;

import com.ahk.data.Product;
import com.ahk.db.sqlite.ProductDBManager;
import com.ahk.ui.controller.UpdateCenterController;
import javafx.application.Platform;

public class UpdateProduct implements Runnable {
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
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Platform.runLater(()->controller.clean());
        }
    }
}
