public class LoanAccount extends Account{
    public LoanAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }
    public void chargeInterest(){
        deposit(getBalance() * 0.05);
    }



}
