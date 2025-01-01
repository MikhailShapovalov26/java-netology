package taxes;

public class USNNetIncome extends TaxSystem{

    @Override
    public double calcTaxFor(int debit, int credit) {
        return Math.max((debit - credit) * 0.15, 0);
    }
}
