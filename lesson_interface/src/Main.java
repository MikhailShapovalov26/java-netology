public class Main {
    public static void main(String[] args) {
        Account account = new CreditAccount("Кредитный счёт", -1000, -5000);
        Account account2 = new SimpleAccount("Дебетовый счёт",20000 );

        account.add(500);
        account.pay(200);
        System.out.println(account.balance);
        System.out.println();
        account2.add(500);
        account2.pay(200);
        System.out.println(account2.balance);
        System.out.println();

//        System.out.println(account.transfer(account2, 3000));
//        System.out.println(account.balance);
//        System.out.println(account2.balance);
//
//        System.out.println(account.transfer(account2, 4000));
//        System.out.println(account.balance);
//        System.out.println(account2.balance);

        System.out.println(account2.transfer(account, 3705));
        System.out.println(account.balance);
        System.out.println(account2.balance);
    }
}
