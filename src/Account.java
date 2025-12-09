import java.util.Objects;

public class Account {

    private String accountNumber;
    private  String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber==null || accountNumber.trim().length()<4 ){
            throw new IllegalArgumentException("Invalid account number");
        }
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
         return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName==null || ownerName.trim().length()<3) {
            throw new IllegalArgumentException("Invalid Owner Name");
        }
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance<0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;

    }
    public void deposit(double amount){
        if (amount>0){
            balance+=amount;
        }
        else System.out.println("Invalid Amount");
    }
    public void withdraw(double amount){
        if (amount>0 && amount<=balance){
            balance-=amount;
        }
        else System.out.println("Not enough balance");
    }


    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }
}

