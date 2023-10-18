package com.example.guiworklist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class ToPayController {

    @FXML
    Label name;

    @FXML
    TextField sal;

    @FXML
    HBox mainBox;


    protected void getNameEmployer() {
        // где нажата кнопка, оттуда из колонки 2 считывается имя


    }

    @FXML
    public void toSavePay() throws IOException {
        mainBox.getChildren().clear();
        String fn = "sal.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fn));
        try{
            bw.write(sal.getText());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        bw.close();
    }




}
