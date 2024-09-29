package com.edu.homework.t09;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label,double xCoordinate, double yCoordinate) {
        super(xCoordinate, yCoordinate);
        this.label = label;
    }

    @Override
    public String toString() {
        return "label = " + label + " ,x = " + getxCoordinate() + " ,y = " + getyCoordinate();
    }
}
