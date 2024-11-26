import java.util.Scanner;

public class User {
    private final Account account;
    private final Scanner scanner = new Scanner(System.in);

    public User(Account account) {
        this.account = account;
    }

    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome, " + account.getName());
            System.out.println("1. Know Account Details");
            System.out.println("2. Balance Inquiry");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                showAccountDetails();
            } else if (choice == 2) {
                balanceInquiry();
            } else if (choice == 3) {
                deposit();
            } else if (choice == 4) {
                withdraw();
            } else if (choice == 5) {
                System.out.println("Thank you for using our services. Goodbye!");
                exit = true;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Show account details
    private void showAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Name: " + account.getName());
        System.out.println("Mobile Number: " + account.getMobileNumber());
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    private void balanceInquiry(){
        System.out.println("Balance: Rs" + account.getBalance());
    }

    // Deposit money
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful! New balance: Rs" + account.getBalance());
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    // Withdraw money
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful! New balance: Rs" + account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount. Please try again.");
        }
    }
}
