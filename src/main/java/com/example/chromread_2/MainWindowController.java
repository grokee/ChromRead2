package com.example.chromread_2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Map;

public class MainWindowController {
    @FXML
    private TabPane tabPane;

    @FXML
    private Stage stage;

    @FXML
    private Tab openTab;

    @FXML
    private Button btnOpenFile;

    @FXML
    private ComboBox comboY;
    @FXML
    private ComboBox comboX;

    @FXML
    private TextField yUnitText;

    @FXML
    private TextField xUnitText;

    @FXML
    private Label xUnitLabel;

    @FXML
    private Label yUnitLabel;

    @FXML
    private TextField startChromFrom;

    @FXML
    private TextField endChromAt;

    @FXML
    private TextField numberOfPeaks;

    @FXML
    private TextField threshold;

    @FXML
    private ComboBox comboMethod;

    @FXML
    private CheckBox normalizationCheck;

    @FXML
    private Button btnCreateChromTab;

    private ChromData chromData;

    private Map.Entry<String, Double[]>[] entryArray;

    private int arrayLength;

    private String yLabel;

    private String xLabel;

    @FXML
    protected void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/main/files"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile!=null) {
            chromData = new ChromData();
            chromData.setMappedDataFromFile(selectedFile.getPath());
            this.setYLabels();
        } else {
            System.out.println("File has not been chosen");
        }
    }

    public void setYLabels() {
        comboY.getItems().removeAll();
        comboY.setItems(chromData.getYLabelsList());
        comboY.getSelectionModel().selectFirst();
    }

    @FXML
    protected void selectYArray() {
        yLabel = comboY.getValue().toString();
        System.out.println(yLabel);
        chromData.setYArrayFromLabel(yLabel);
        comboX.getItems().removeAll();
        comboX.getItems().addAll(chromData.getXLabelsList(yLabel));
        comboX.getSelectionModel().selectFirst();
    }

    @FXML
    protected void selectXArray() {
        xLabel = comboX.getValue().toString();
        chromData.setXArrayFromLabel(xLabel);
        yUnitText.setText(chromData.getUnitY());
        yUnitLabel.setText(chromData.getUnitY());
        xUnitLabel.setText(chromData.getUnitX());
        xUnitText.setText(chromData.getUnitX());
        startChromFrom.setText(Double.toString(chromData.getFragmentFrom()));
        endChromAt.setText(Double.toString(chromData.getFragmentTo()));
        numberOfPeaks.setText(Integer.toString(chromData.getPeaksNumber()));
        threshold.setText(Double.toString(chromData.getThreshold()));
        comboMethod.setItems(chromData.getMethodList());
        comboMethod.getSelectionModel().selectFirst();
        normalizationCheck.setSelected(true);
//        btnCreateChromTab.setDisable(false);
    }

    @FXML
    protected void assignYUnit(){

    }

    @FXML
    protected void assignXUnit(){

    }

    @FXML
    protected void setStartChromFrom(){

    }

    @FXML
    protected void setEndChromAt(){

    }

    @FXML
    protected void setNumberOfPeaks(){

    }

    @FXML
    protected void checkNormalization(){

    }

    @FXML
    protected void setThreshold(){

    }

    @FXML
    protected void selectComboMethod(){

    }

    @FXML
    protected void createChromTab() {
        Tab chromTab = new Tab("Chrom Tab");
        ChromAnchorPane chromPane = new ChromAnchorPane(chromData.getXArray(),chromData.getyArray());
        chromTab.setContent(chromPane.getChromAnchorPane());
        tabPane.getTabs().add(chromTab);
        tabPane.getSelectionModel().select(chromTab);

    }




}