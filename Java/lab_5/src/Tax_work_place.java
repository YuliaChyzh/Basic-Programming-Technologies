
public class Tax_work_place extends Tax{
    private double tax;
    public Tax_work_place(double tax)
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
