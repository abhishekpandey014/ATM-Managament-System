import java.util.Random;

public class Account {
    private final int pin;
    private double balance;
    private final String name;
    private final String mobileNumber;
    private final int accountNumber;

    public Account(String name, int pin, double initialDeposit, String mobileNumber) {
        this.name = name;
        this.pin = pin;
        this.balance = initialDeposit;
        this.mobileNumber = mobileNumber;
        this.accountNumber = generateAccountNumber();
    }

    // Generate random 6-digit account number
    private int generateAccountNumber() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000); // Random number between 100000 and 999999
    }

    // Getter and Setter methods
    public int getPin() { return pin; }
    public double getBalance() { return balance; }
    public String getName() { return name; }
    public String getMobileNumber() { return mobileNumber; }
    public int getAccountNumber() { return accountNumber; }
    public void setBalance(double balance) { this.balance = balance; }
}
