package org.apps.quantitymeasurement;

public interface IMeasurableUC10 {

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();
}