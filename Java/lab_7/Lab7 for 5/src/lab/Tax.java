package lab;

public abstract class Tax {
    double tax;
    Tax(double tax)
    {
        this.tax = tax;
    }
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
