package com.example.chromread_2;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.StackPane;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import javafx.embed.swing.SwingNode;
import org.knowm.xchart.XYChart;


import javax.swing.*;


public class ChromAnchorPaneController {

    private double[] xData={1,2,3};
    private double[] yData={2,4,6};

//    public void setXArray(double[] inputXArray){
//         xArray = inputXArray;
//    }
//
//    public void setYArray(double[] inputYArray) {
//        yArray = inputYArray;
//    }

    @FXML
    private AnchorPane anchPane;

    @FXML
    private StackPane stackPane;

    public void createChromatogram(){

//        DataPlotter dataPlotter = new DataPlotter();
//        XYChart graph = dataPlotter.simplePlot(xArray, yArray);

        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
        XChartPanel chartPanel = new XChartPanel(chart);
        SwingNode swingNode = new SwingNode();

        System.out.println(xData[0]);
        JButton btn = new JButton("click");
//        Button btn = new Button("i am here");
//        XChartPanel tabBody = new XChartPanel<XYChart>(graph);
//        XChartPanel<Chart<? extends Styler, ? extends Series>> tabBody = new XChartPanel<>(graph);
        createSwingContent(swingNode,btn);
//        getChart(swingNode,tabBody);
        System.out.println(xData[1]);

        stackPane.getChildren().add(swingNode);
        System.out.println(xData[2]);

    }

    private void createSwingContent(final SwingNode swingNode, JButton chartPanel) {
        SwingUtilities.invokeLater(() -> {
            swingNode.setContent(chartPanel);
        });
    }

    private void getChart(final SwingNode sn, XChartPanel chart){
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        sn.setContent(chart);
                    }
                });
    }

    @FXML private Button btnUpdate;
    public void setBtnUpdateName(){
        btnUpdate.setText("Cklicked");
    }
}
