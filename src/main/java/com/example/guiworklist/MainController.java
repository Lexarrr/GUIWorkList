package com.example.guiworklist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class MainController {

    @FXML
    private Label name;

    @FXML
    private Label salaryInTheMonth;

    @FXML
    private Label savings;

    @FXML
    Button click;

    @FXML
    Button payClick;

    @FXML
    GridPane gp;

    @FXML
    Label warn;


    @FXML
    protected void toAddNewWorker() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("new-worker.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Add Employer");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }

        buttonAddOnTable();
//        toCreateBd(gp);

    }

    private void toCreateBd(GridPane gridPane) throws IOException {
        int id = 1;
        int k = gp.getRowCount();
        Map<Integer, Node> workerMap = new HashMap<>();
        while (k > 0)
            for (int i = 1; i < gridPane.getColumnCount(); i++) {
                workerMap.put(id++, gp.getChildren().get(i));
            }
        String fn = "BDList.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fn));
        try {
            bw.write(workerMap.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bw.close();
    }

    private void buttonAddOnTable() {
        click.setOnAction(actionEvent -> {
            try {
                toShowNewWorker(gp);
            } catch (IOException | ExcFormatField | MineException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public void toShowNewWorker(GridPane g) throws IOException, ExcFormatField, MineException {
        int row = gp.getRowCount();
        int col = gp.getColumnCount();
        List<String> ls = getInfoEmployers();

        g.addColumn(0, new Label(String.valueOf(row)));
        for (String c : ls) {
            g.addRow(row, new Label(c));
            col++;
        }
        toSal(g);
        toSetSavings(g);
        toMenu(g);
        gp.setId("stringRow");


    }

    public void toMenu(GridPane gridPane) {
        MenuItem mI1 = new MenuItem("Go to bar");
        MenuItem mI2 = new MenuItem("To pay tax");
        MenuItem mI3 = new MenuItem("To quit");

        MenuButton mb = new MenuButton("Options", null, mI1, mI2, mI3);
        mb.setId("button");
        gridPane.addColumn(8, mb);

        actForEmployer(gridPane, mI1, mI2, mI3);


    }

    private void actForEmployer(GridPane gridPane, MenuItem mI1, MenuItem mI2, MenuItem mI3) {
        mI1.setOnAction(actionEvent -> goToBar(gridPane));
        mI2.setOnAction(vent -> toPayTax(gridPane));
        mI3.setOnAction(actionEvent -> gridPane.getRowConstraints().clear());
    }

    private void toPayTax(GridPane gg) {
        double sgt = Double.parseDouble(savings.getText());
        double tsp = 0.13;
        double tax = sgt*tsp;
        String res = String.valueOf(sgt - tax);
        savings.setText(res);
        int row = gp.getRowCount()-1;
        gg.add(savings, 7, row);
    }

    private void goToBar(GridPane gridPane) {
        Random ran = new Random();
        double sgt = Double.parseDouble(savings.getText());
        double tsp = ran.nextInt(2000);
        if (tsp > sgt){
            warn.setText("you don't have enough funds!");

        } else {
            String res = String.valueOf(sgt - tsp);
            savings.setText(res);
            int row = gp.getRowCount() - 1;
//            gp.gridLinesVisibleProperty();
            gridPane.add(savings, 7, row);
        }
    }


    private void toSetSavings(GridPane gg) {
        Random ran = new Random();
        Label l = new Label();
        l.setText(String.valueOf(ran.nextInt(5000)));
        savings = l;
        gg.addColumn(7, savings);

    }

    public void toSal(GridPane gg) {
        Button b = new Button();
        b.setText("Set salary");
        b.setId("button");
        gg.addColumn(6, b);

        b.setOnAction(actionEvent -> openRast());

        changeAction(gg, b);
    }

    private void changeAction(GridPane gg, Button b) {
        click.setOnAction(a -> {
            b.setText("To pay");
            b.setOnAction(s -> {
                try {
                    double sgt = Double.parseDouble(savings.getText());
                    double tsp = toShowPay();
                    String res = String.valueOf(sgt + tsp);
                    savings.setText(res);
                    int row = gp.getRowCount()-1;
                    gg.add(savings, 7, row);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    private void openRast() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("to-pay.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("To pay salary");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }


    }

    public static int toShowPay() throws IOException {
        Scanner reader = new Scanner(new FileReader("sal.txt"));
        return reader.nextInt();
    }



    private static List<String> getInfoEmployers() throws FileNotFoundException {
        String fn = "employersList.txt";
        Scanner br = new Scanner(new FileReader(fn));
        List<String> ls = new ArrayList<>();
        while (br.hasNext()) {
            String s = br.next();
            s = s.replace("[", "");
            s = s.replace("]", "");
            s = s.replace(",", "");
            ls.add(s);
        }

        return ls;
    }



    @FXML
    protected void toQuit() {



    }


}