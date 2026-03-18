package UC2;

public class Feet {
    private double value;

    public Feet(double value) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
    }

    public double toInches() {
        return value * 12;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Feet other = (Feet) obj;
        return Double.compare(this.value, other.value) == 0;
    }
}