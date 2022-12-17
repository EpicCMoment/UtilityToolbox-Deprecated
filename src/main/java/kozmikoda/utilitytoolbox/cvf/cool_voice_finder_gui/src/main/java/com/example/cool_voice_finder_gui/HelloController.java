package com.example.cool_voice_finder_gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.File;

public class HelloController {
    CoolVoiceController fileObj = new CoolVoiceController();

    @FXML
    private TextField output;

    Stage stage;
    @FXML
    protected void selectFileButton() {
        output.setText(" ");
        File voice = fileObj.selectFile();
        String data = fileObj.startCVF(voice);
        output.setText(data);
        output.setVisible(true);
    }

    @FXML
    protected void closeButton(ActionEvent event) {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }
}