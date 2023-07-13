class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance to withdraw $" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankAccountMain {
    public static void main(String[] args) {
        // Create a bank account object
        BankAccount bankAccount = new BankAccount("1234567890");

        // Deposit money into the account
        bankAccount.deposit(1000.0);
        bankAccount.deposit(1500.0);

        // Withdraw money from the account
        bankAccount.withdraw(300.0);
        bankAccount.withdraw(1200.0);

        // Print the account number and balance
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }
}