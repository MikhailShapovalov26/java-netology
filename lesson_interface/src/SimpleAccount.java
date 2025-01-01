public class SimpleAccount extends  Account{
    public SimpleAccount(String name, long balance) {
        super(name, balance);
    }

    @Override
    public boolean add(long amount) {
        balance+=amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {

        if(balance > 0 && balance - amount >= 0){
            balance-=amount;
            return true;
        };
        return false;
    }

    @Override
    public boolean transfer(Account account, long amount) {
        if (pay(amount)){
            if(account.add(amount)){
                return true;
            }else{
                add(amount);
                System.out.println("Возврат на счёт "+ account.name + " cуммы " + amount);
            }
        }
        return false;
    }
    @Override
    public long getBalance() {
        return balance;
    }
}
