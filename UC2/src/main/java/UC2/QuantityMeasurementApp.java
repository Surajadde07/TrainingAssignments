package UC2;

public class QuantityMeasurementApp {

    public static boolean compareFeet(double a, double b) {
        Feet f1 = new Feet(a);
        Feet f2 = new Feet(b);
        return f1.equals(f2);
    }

    public static boolean compareInches(double a, double b) {
        Inch i1 = new Inch(a);
        Inch i2 = new Inch(b);
        return i1.equals(i2);
    }

    public static boolean compareFeetAndInch(double feet, double inch) {
        Feet f = new Feet(feet);
        Inch i = new Inch(inch);

        return Double.compare(f.toInches(), i.getValue()) == 0;
    }

    public static void main(String[] args) {
        System.out.println(compareFeet(1.0, 1.0));       // true
        System.out.println(compareInches(1.0, 1.0));     // true
        System.out.println(compareFeetAndInch(1.0, 12)); // true
    }
}