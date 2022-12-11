package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("Scene.fxml"));
        Scene scene = new Scene(root);
         stage.setWidth(715);
         stage.setY(50);
         stage.setMinHeight(500);
         stage.setMinWidth(700);
         stage.setMaxHeight(500);
         stage.setMaxWidth(715);

         stage.setHeight(500);
        stage.setTitle("gameGuess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}