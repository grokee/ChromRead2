package com.example.chromread_2;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.io.IOException;

public class ChromAnchorPane extends AnchorPane {

    private StackPane stackPane;

    public ChromAnchorPane(double[] x, double[] y){
        xArray = x;
        yArray = y;
    }

    private double[] xArray;
    private double[] yArray;

//    public void setXArray(double[] inputX){
//        xArray=inputX;
//    }
//
//    public void setYArray(double[] inputY){
//        yArray=inputY;
//    }

    public AnchorPane getChromAnchorPane(){

        FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("chromAnchorPane.fxml"));

        AnchorPane ap1 = null;
        try {
            ap1 = fxmlLoader.load();
            System.out.println("ChromAnchor was loaded");
            ap1.getChildren().add(getXChart(xArray,yArray));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ap1;
    }

    public SwingNode getXChart(double[] x, double[] y){

        DataPlotter dataPlotter = new DataPlotter();
        XYChart chart = dataPlotter.simplePlot(x,y);
//        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
        XChartPanel chartPanel = new XChartPanel(chart);
        SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode,chartPanel);
        return swingNode;
    }

    private void createSwingContent(SwingNode swingNode, XChartPanel chartPanel) {
        SwingUtilities.invokeLater(() -> {
            swingNode.setContent(chartPanel);
        });
    }
}
