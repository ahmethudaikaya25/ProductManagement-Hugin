package com.ahk.ui.db_access;

import com.ahk.data.Product;
import com.ahk.db.sqlite.ProductDBManager;
import com.ahk.ui.controller.UpdateCenterController;

public class FindOneProduct implements Runnable {
    private UpdateCenterController controller;
    private String name;
    private Integer id;

    public FindOneProduct(UpdateCenterController controller) {
        this.controller = controller;

        if(!controller.idTextF.getText().isEmpty()){
            id = Integer.valueOf(controller.idTextF.getText());
        }
        name = controller.nameTextF.getText();


        System.out.println("Const id:"+id);
        System.out.println("Const name:"+name);
    }
    private Product findWithName(String name){
        ProductDBManager manager = new ProductDBManager();
        return manager.getProductWithName(name);
    }
    private Product findWithId(Integer id){
        ProductDBManager manager = new ProductDBManager();

        return manager.getProductWithId(id);
    }
    @Override
    public void run() {
        Product product = new Product();
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
        if(id==null&&!(name.isEmpty())){
            System.out.println("Name2: "+name);
            product = findWithName(name);
            controller.idTextF.setDisable(false);
            controller.nameTextF.setDisable(true);
        }else if(!(id==null)&&name.isEmpty()){
            System.out.println("Id2: "+id);
            product = findWithId(id);
            controller.nameTextF.setDisable(false);
            controller.idTextF.setDisable(true);
        }
        controller.updateButton.setDisable(false);
        controller.searchButton.setDisable(true);
        controller.priceTextF.setDisable(false);
        controller.valComboBox.setVisible(false);
        controller.valComboBox.setDisable(false);
        controller.valComboBox.setVisible(true);
        controller.barcodeTextF.setDisable(false);
        controller.idTextF.setText(String.valueOf(product.getId()));
        controller.nameTextF.setText(product.getName());
        controller.priceTextF.setText(String.valueOf(product.getPrice()));
        controller.valComboBox.getSelectionModel().select("8");
        controller.barcodeTextF.setText(product.getBarcode());
    }
}
