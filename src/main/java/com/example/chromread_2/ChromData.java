package com.example.chromread_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

public class ChromData {

    private Map.Entry<String, Double[]>[] entryArray;
    private double[] arrayY;
    private double[] arrayX;

    public double[] getXArray(){
        return arrayX;
    }

    public double[] getyArray(){
        return arrayY;
    }
    private String unitY="intensity";
    private String unitX="sek";

    private double fragmentFrom = 0;

    private double fragmentTo;

    private int peaksNumber=5;

    private double threshold=0;

    private ObservableList<String> methodList = FXCollections.observableArrayList(
                                    "midpoint",
                                    "trapezoidal",
                                        "Simpson's");




    public void setMappedDataFromFile(String filePath){
        ArrayCooker arraysFromFile = new ArrayCooker();
        arraysFromFile.loadFile(filePath);
        entryArray = arraysFromFile.getSetOfArray();
    }

    public ObservableList getYLabelsList() {
        ObservableList obsStringArray = FXCollections.observableArrayList();
        for (int i = 0; i < entryArray.length; i++) {
            obsStringArray.add(entryArray[i].getKey().substring(0, 40));
        }
        return obsStringArray;
    }

    public ObservableList getXLabelsList(String yLabel){
        ObservableList obsStringArray = FXCollections.observableArrayList();
        if ((yLabel!= null) && (arrayY.length != 0)) {
            for (int i = 0; i < entryArray.length; i++) {
                if ((entryArray[i].getValue().length == arrayY.length) && (!yLabel.contains(entryArray[i].getKey().substring(0, 40)))) {
                    System.out.println(entryArray[i].getKey());
                    obsStringArray.add(entryArray[i].getKey().substring(0, 40));
                }
            }
        } else {
            obsStringArray.add("Y-array has not been chosen");
        }
        return obsStringArray;
    }

    public void setYArrayFromLabel(String yLabel){
        for (int i = 0; i < entryArray.length; i++) {
            String subString = entryArray[i].getKey().substring(0, 40);
            if (yLabel.contains(subString)) {
                arrayY = ArrayUtils.toPrimitive(entryArray[i].getValue());
            }
        }
    }

    public void setXArrayFromLabel(String xLabel){
        for (int i = 0; i < entryArray.length; i++) {
            String subString = entryArray[i].getKey().substring(0, 40);
            if (xLabel.contains(subString)) {
                arrayX = ArrayUtils.toPrimitive(entryArray[i].getValue());
            }
        }

    }

    public String getUnitY(){
        return unitY;
    }

    public String getUnitX(){
        return unitX;
    }

    public void setUnitY(String inputYUnit){
        unitY = inputYUnit;
    }

    public void setUnitX(String inputXUnit){
        unitX = inputXUnit;
    }

    public double getFragmentFrom(){
        return fragmentFrom;
    }

    public double getFragmentTo(){
        fragmentTo = arrayX[arrayX.length-1];
        return fragmentTo;
    }

    public int getPeaksNumber(){
        return peaksNumber;
    }

    public double getThreshold(){
        return threshold;
    }

    public ObservableList getMethodList(){
        return methodList;
    }

    public void setFragmentFrom(double inputFragmentFrom){
        fragmentFrom = inputFragmentFrom;
    }

    public void setFragmentTo(double inputFragmentTo){
        fragmentTo = inputFragmentTo;
    }

    public void setNumberOfPeaks(int inputNumberOfPeaks){
        peaksNumber = inputNumberOfPeaks;
    }

    public void setThreshold(double inputThreshold){
        threshold = inputThreshold;
    }

    public void normalizedYArray(double[] unnormalizedYArray){

    }




}
