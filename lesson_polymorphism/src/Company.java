import taxes.TaxSystem;

public class Company {

    private String title;
    private int debid;
    private int credit;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.debid = 0;
        this.credit = 0;
        this.taxSystem = taxSystem;
    }

    public String getTitle() {
        return title;
    }

    public long getCredit() {
        return credit;
    }


    public void shiftMoney(int amount) {
        if (amount > 0) {
            setDebid(debid + amount);
        } else if (amount < 0) {
            setCredit(credit + Math.abs(amount));
        }
    }

    public void setCredit(int i) {
        credit += i;
    }

    public void setDebid(int i) {
        debid += i;
    }

    public void payTaxes() {
        System.out.printf("Компания %S уплатила налог в размере: %.2f руб.%n", title, taxSystem.calcTaxFor(debid, credit));
        debid = 0;
        credit = 0;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }
}
