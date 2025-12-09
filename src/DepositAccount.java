public class DepositAccount extends Account{
    public DepositAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }
    public void addMonthlyBonus(){
        deposit(getBalance() * 0.01);
    }

}
