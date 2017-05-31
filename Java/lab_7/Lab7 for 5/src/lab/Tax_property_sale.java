package lab;

public class Tax_property_sale extends Tax{
    private double tax;
    public Tax_property_sale(double tax)
    {
        super(tax);
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString()
    {
        return Double.toString(tax);
    }
}
