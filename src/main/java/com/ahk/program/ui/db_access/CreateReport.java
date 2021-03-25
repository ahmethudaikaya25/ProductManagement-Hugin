package com.ahk.program.ui.db_access;

import com.ahk.program.data.Product;
import com.ahk.db.sqlite.dbManager.ProductDBManager;
import com.ahk.program.ui.util.AlertManager;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CreateReport implements Runnable, AsyncDBAccess {
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
        try {
            if (!file.exists()) {
                Path path = Paths.get("./report/");
                Files.createDirectories(path);
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(s);
            bufferedWriter.close();
            fileWriter.close();
            Platform.runLater(this::onSuccess);
        } catch (IOException e) {
            Platform.runLater(() -> onError(e));
        }
    }

    @Override
    public void onSuccess() {
        new AlertManager().alertType(Alert.AlertType.INFORMATION).title("Report")
                .message("Report is created...").showInformation();

    }

    @Override
    public void onError(Exception e) {
        new AlertManager().alertType(Alert.AlertType.ERROR).title("Report").header("Report can't created...")
                .message(e.getMessage()).showInformation();
    }
}
