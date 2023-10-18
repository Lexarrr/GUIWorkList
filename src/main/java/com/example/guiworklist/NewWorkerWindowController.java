package com.example.guiworklist;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewWorkerWindowController {


    @FXML
    private TextField fname;
    @FXML
    private TextField sname;
    @FXML
    private TextField yearOld;
    @FXML
    private TextField workExperience;
    @FXML
    private TextField position;
    @FXML
    private Label exc;
    @FXML
    Button clicker;
    @FXML
    VBox mainBox;


    @FXML
    protected void ToSave() throws IOException {
        mainBox.getChildren().clear();
        List<Worker> employers = new ArrayList<>();
        try {
            employers.add(new Worker(fname.getText(), sname.getText(),
                    position.getText(), Integer.parseInt(yearOld.getText()),
                    Integer.parseInt(workExperience.getText())));

        } catch (MineException e) {
            exc.setText("You should to fill the form!");
        } catch (ExcFormatField e) {
            exc.setText("Check your age or work experience. " +
                    "Age cannot be less than 18 years, work experience cannot be more than age!");
        }

        String fn = "employersList.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fn));
        try {
            bw.write(employers.toString()); //eventHandler.handle(bw.write(personMap.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bw.close();

        openDialog();


    }


    @FXML
    protected void toDelete() {
        for (Node text : mainBox.getChildren()) {
            if (text instanceof TextField) {
                ((TextField) text).clear();
            }
        }
    }

    private void openDialog() {

            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(new Stage());
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("successfully added!"));
            Scene dialogScene = new Scene(dialogVbox, 150, 100);
            dialog.setScene(dialogScene);
            dialog.show();
    }
}
