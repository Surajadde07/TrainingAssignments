package org.apps.quantitymeasurement.dto;

public class QuantityDTOUC15 {

    private double value;
    private String unit;
    private String measurementType;

    public QuantityDTOUC15(double value, String unit, String measurementType) {
        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    public double getValue() { return value; }
    public String getUnit() { return unit; }
    public String getMeasurementType() { return measurementType; }
}
