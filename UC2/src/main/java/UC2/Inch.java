package UC2;

public class Inch {
    private double value;

    public Inch(double value) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double toFeet() {
        return value / 12;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Inch other = (Inch) obj;
        return Double.compare(this.value, other.value) == 0;
    }
}