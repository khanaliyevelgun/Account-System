import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       ArrayList<Account> accounts = new ArrayList<>();

        int choice=-1;
       while (choice!=0) {
           System.out.println("""
                   1.Create account
                   2.Deposit
                   3.Withdraw
                   4.Run special action
                   5.Show account info
                   0.Exit""");
           System.out.print("Enter your choice: ");
           try {
               choice = scanner.nextInt();
               scanner.nextLine();
           } catch (Exception e) {
               System.out.println("Invalid input. Please enter a number.");
               scanner.nextLine();
               choice = -1;
           }

           switch (choice) {
               case 0 -> System.out.println("Exiting... Goodbye!");
               case 1 -> {createAccount(scanner, accounts); }

               case 2 ->{
                   deposit(askAndFind(scanner, accounts), scanner);
               }
               case 3 ->{

                   withdraw(askAndFind(scanner,accounts),scanner);
               }
               case 4 -> {
                   String accNumber=askAccountNumber(scanner);
                   Account acc = findAccount(accounts,accNumber);
                   accType(acc);

               }
               case 5 -> {
                   String accNumber=askAccountNumber(scanner);
                   Account account = findAccount(accounts,accNumber);
                   if (account==null){
                       System.out.println("Account not found");
                   }
                   else {
                       System.out.println(account);
                   }
               }
               default -> System.out.println("Invalid choice");

           }


       }
    }
    public static Account askAndFind(Scanner sc, ArrayList<Account> accs) {
        return findAccount(accs, askAccountNumber(sc));
    }
    public static Account findAccount(ArrayList<Account> accounts,String accountNumber){
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
       return null;
    }
    public static String askAccountNumber(Scanner scanner) {
        System.out.print("Enter account number: ");
        return scanner.nextLine().trim();
    }
    public static void createAccount(Scanner scanner,ArrayList<Account> accounts) {
        try {
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.nextLine();
            if (findAccount(accounts, accountNumber) != null) {
                System.out.println("Account with this number already exists!");
                return;
            }
            System.out.print("Enter Owner Name: ");
            String ownerName = scanner.nextLine();
            System.out.print("Enter Balance: ");
            double balance = scanner.nextDouble();
            System.out.println("""
                    1.Loan Account
                    2.Deposit Account
                    3.Mortage Account """);
            System.out.print("Enter account type: ");
            int type = scanner.nextInt();
            scanner.nextLine();
            Account acc = null;
            switch (type) {
                case 1 -> {
                    acc = new LoanAccount(accountNumber, ownerName, balance);
                }
                case 2 -> {
                    acc = new DepositAccount(accountNumber, ownerName, balance);
                }
                case 3 -> {
                    acc = new MortageAccount(accountNumber, ownerName, balance);
                }
                default -> System.out.println("Invalid type");

            }
            if (acc != null) {
                accounts.add(acc);
                System.out.println("Account created");
            } else System.out.println("Account could not be created");
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        }
    }
    public static void deposit(Account acc,Scanner scanner){
        if (acc==null){
            System.out.println("Account not found");
        }
        else {
            try {
                System.out.print("How much you want to deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Clear buffer
                acc.deposit(amount);
                System.out.println("Successfully deposited");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }

        }
    }
    public static void withdraw(Account acc,Scanner scanner){
        if (acc==null){
            System.out.println("Account not found");
        }
        else {
            try {
                System.out.print("How much you want to deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Clear buffer
                acc.deposit(amount);
                System.out.println("Successfully deposited");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }

        }
    }
    public static void accType(Account acc){
        if (acc==null){
            System.out.println("Account not found");
        }
        else {
            switch (acc) {
                case LoanAccount loanAccount -> {
                    loanAccount.chargeInterest();
                    System.out.println("Interest charged");
                }
                case DepositAccount account -> {
                    account.addMonthlyBonus();
                    System.out.println("Bonus added");
                }
                case MortageAccount account -> {
                    account.addMonthlyFee();
                    System.out.println("Montly fee added");
                }
                default -> {
                }
            }
        }
    }


}
