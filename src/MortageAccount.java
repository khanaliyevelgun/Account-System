public class MortageAccount extends Account{
    public MortageAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }
    public void addMonthlyFee(){
        if (getBalance()>=10){
            withdraw(10);
        }
     else {
        System.out.println("Insufficient balance for monthly fee");
    }
    }
}
