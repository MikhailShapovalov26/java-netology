class Account {
    String name;
    long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean add(long amount) {
        return false;
    }


    public boolean pay(long amount) {
        return false;
    }


    public boolean transfer(Account account, long amount) {

        return false;
    }


    public long getBalance() {
        return balance;
    }

}
