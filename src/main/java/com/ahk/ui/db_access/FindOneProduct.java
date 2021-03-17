package com.ahk.ui.db_access;

import com.ahk.data.Product;
import com.ahk.db.sqlite.ProductDBManager;
import com.ahk.ui.controller.UpdateCenterController;
import com.ahk.ui.util.AlertManager;
import javafx.application.Platform;

public class FindOneProduct implements Runnable, AsyncDBAccess {
    private UpdateCenterController controller;
    private String name;
    private Integer id;
    private Product product = null;
    private int type;

    public FindOneProduct(UpdateCenterController controller) {
        this.controller = controller;

        if (!controller.idTextF.getText().isEmpty()) {
            id = Integer.valueOf(controller.idTextF.getText());
        }
        name = controller.nameTextF.getText();


        System.out.println("Const id:" + id);
        System.out.println("Const name:" + name);
    }

    private Product findWithName(String name) {
        ProductDBManager manager = new ProductDBManager();
        return manager.getProductWithName(name);
    }

    private Product findWithId(Integer id) {
        ProductDBManager manager = new ProductDBManager();
        return manager.getProductWithId(id);
    }

    @Override
    public void run() {
        product = new Product();
        if (id == null && !(name.isEmpty())) {
            product = findWithName(name);
            if (product == null) {
                Platform.runLater(this::showAlert);
            } else {
                type = 1;
                Platform.runLater(this::onSuccess);
            }
        } else if (!(id == null) && name.isEmpty()) {

            product = findWithId(id);
            if (product == null) {
                Platform.runLater(this::showAlert);
            } else {
                type = 2;
                Platform.runLater(this::onSuccess);
            }
        }

    }

    public void showAlert() {
        AlertManager manager = new AlertManager();
        manager.title("Search").message("This product don't found").showInformation();
    }

    @Override
    public void onSuccess() {
        switch (type) {
            case 1:
                controller.idTextF.setDisable(false);
                controller.nameTextF.setDisable(true);
                controller.updateButton.setDisable(false);
                controller.searchButton.setDisable(true);
                controller.priceTextF.setDisable(false);
                controller.valComboBox.setDisable(false);
                controller.barcodeTextF.setDisable(false);
                controller.idTextF.setText(String.valueOf(product.getId()));
                controller.nameTextF.setText(product.getName());
                controller.priceTextF.setText(String.valueOf(product.getPrice()));
                final Integer i = product.getVal();
                controller.valComboBox.getSelectionModel().select(String.valueOf(i));
                controller.barcodeTextF.setText(product.getBarcode());
                break;
            case 2:
                controller.nameTextF.setDisable(false);
                controller.idTextF.setDisable(true);
                controller.updateButton.setDisable(false);
                controller.searchButton.setDisable(true);
                controller.priceTextF.setDisable(false);
                controller.valComboBox.setDisable(false);
                controller.barcodeTextF.setDisable(false);
                controller.idTextF.setText(String.valueOf(product.getId()));
                controller.nameTextF.setText(product.getName());
                controller.priceTextF.setText(String.valueOf(product.getPrice()));
                final Integer a = product.getVal();
                Platform.runLater(() -> controller.valComboBox.getSelectionModel()
                        .select(String.valueOf(a)));
                controller.barcodeTextF.setText(product.getBarcode());
                break;
            default:
                break;
        }

    }

    @Override
    public void onError(Exception e) {

    }
}
