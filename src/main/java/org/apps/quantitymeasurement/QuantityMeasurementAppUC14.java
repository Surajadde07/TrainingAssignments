package org.apps.quantitymeasurement;

public class QuantityMeasurementAppUC14 {

    public static void main(String[] args) {

        QuantityUC14<LengthUnitUC14> l1 = new QuantityUC14<>(10, LengthUnitUC14.FEET);
        QuantityUC14<LengthUnitUC14> l2 = new QuantityUC14<>(12, LengthUnitUC14.INCH);

        System.out.println("Length Add: " + l1.add(l2));

        QuantityUC14<VolumeUnitUC14> v1 = new QuantityUC14<>(5, VolumeUnitUC14.LITRE);
        QuantityUC14<VolumeUnitUC14> v2 = new QuantityUC14<>(2, VolumeUnitUC14.LITRE);

        System.out.println("Volume Subtract: " + v1.subtract(v2));

        QuantityUC14<TemperatureUnitUC14> t1 =
                new QuantityUC14<>(0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> t2 =
                new QuantityUC14<>(32, TemperatureUnitUC14.FAHRENHEIT);

        System.out.println("Temperature Equal: " + t1.equals(t2));

        System.out.println("Temp Convert: " +
                t1.convertTo(TemperatureUnitUC14.FAHRENHEIT));


        try {
            System.out.println(t1.add(t2));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}