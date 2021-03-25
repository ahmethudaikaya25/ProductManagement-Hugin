package com.ahk.program.ui.util;

import com.ahk.program.ui.starter.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class SetCenter {
    private Pane view;

    public Pane getPage(String fileName) {
        try {
            URL url = Main.class.getResource("/com/ahk/center/" + fileName + ".fxml");
            view = FXMLLoader.load(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
