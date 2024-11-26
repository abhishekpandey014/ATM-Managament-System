import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManager {
    private final Map<Integer, Account> pinAccounts = new HashMap<>();

    // Create a new account
    public void createNewAccount(Scanner scanner) {
        System.out.print("Enter your name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();

        System.out.print("Enter your mobile number: ");
        String mobileNumber = scanner.nextLine();

        // Check if an account with the same mobile number already exists
        for (Account account : pinAccounts.values()) {
            if (account.getMobileNumber().equals(mobileNumber)) {
                System.out.println("An account with this mobile number already exists. Access existing account instead.");
                return;
            }
        }

        System.out.print("Create a 4-digit PIN: ");
        int pin = scanner.nextInt();

        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        Account newAccount = new Account(name, pin, initialDeposit, mobileNumber);
        pinAccounts.put(pin, newAccount);

        System.out.print("Account created successfully! ");
        System.out.println("Your Account Number: " + newAccount.getAccountNumber());
    }

    // Access existing account by PIN
    public Account accessAccount(int pin) {
        return pinAccounts.getOrDefault(pin, null);
    }
}
