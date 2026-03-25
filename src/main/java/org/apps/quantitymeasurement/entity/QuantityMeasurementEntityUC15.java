package org.apps.quantitymeasurement.entity;

import java.io.Serializable;

public class QuantityMeasurementEntityUC15 implements Serializable {

    private String operation;
    private String result;
    private boolean isError;

    public QuantityMeasurementEntityUC15(String operation, String result) {
        this.operation = operation;
        this.result = result;
        this.isError = false;
    }

    public QuantityMeasurementEntityUC15(String error) {
        this.result = error;
        this.isError = true;
    }

    public boolean isError() { return isError; }

    @Override
    public String toString() {
        return isError ? "Error: " + result : operation + " => " + result;
    }
}