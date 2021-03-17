package com.ahk.ui.db_access;

import com.ahk.data.Product;
import com.ahk.db.sqlite.ProductDBManager;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateReport implements Runnable {
    private TextArea textArea;

    public CreateReport(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        ProductDBManager manager = new ProductDBManager();
        List<Product> products = manager.getAllProducts();
        String s = "Products :" +
                "\n[\n";
        for (Product product : products) {
            s = s + product.toString() + ",\n";
        }
        s = s + "]";
        this.textArea.setText(s);
        File file = new File("./report/report.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(s);
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
            }
        }
    }
}
