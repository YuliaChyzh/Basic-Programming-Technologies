
public class Tax { // Tax
    double tax;
    Tax(){
        tax = 0;
    }

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

    @Override
    public String toString()
    {
        return Double.toString(tax);
    }
}
