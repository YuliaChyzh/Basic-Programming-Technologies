/**
 * Created by ExeKiller on 06.05.2016.
 */
public class Tax_money_present extends Tax {
    private double tax;
    public Tax_money_present(double tax)
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
