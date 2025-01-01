import taxes.TaxSystem;
import taxes.USNIcome;
import taxes.USNNetIncome;


public class Main {
    public static void main(String[] args) {

        Company companyA = new Company(
                "Сбербанк",
                new TaxSystem()
        );
        companyA.setDebid(10);
        companyA.setDebid(10000);
        companyA.setCredit(500);
        companyA.setCredit(1500);

        companyA.setTaxSystem(new USNIcome());
        companyA.payTaxes();
        companyA.setTaxSystem(new USNNetIncome());
        companyA.payTaxes();

    }
}
