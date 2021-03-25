package com.ahk.program.ui.starter;

import com.ahk.db.server.SpringInitializr;
import com.ahk.db.sqlite.ConnectionProvider;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.InetAddress;

public class Main extends Application {

    @FXML
    Label ip_label;

    public static void main(String[] args) {
        Thread thread = new Thread(new SpringInitializr(args));
        thread.start();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/ahk/main.fxml"));
        Scene scene = new Scene(root);


        primaryStage.setScene(scene);
                InetAddress inetAddress = InetAddress.getLocalHost();
        primaryStage.setTitle("Message App listening: http://"+inetAddress.getHostAddress()+":2525/");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        ConnectionProvider.getInstance().close();
        System.out.println("Connection closed");
    }
}
