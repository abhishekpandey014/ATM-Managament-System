import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the ATM System");
            System.out.println("1. Create New Account");
            System.out.println("2. Access Existing Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                accountManager.createNewAccount(scanner);
            } else if (choice == 2) {
                accessExistingAccount(accountManager, scanner);
            } else if (choice == 3) {
                System.out.println("Thank you for using the ATM System. Goodbye!");
                exit = true;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to access an existing account
    private static void accessExistingAccount(AccountManager accountManager, Scanner scanner) {
        System.out.print("Enter your 4-digit PIN: ");
        int pin = scanner.nextInt();

        Account account = accountManager.accessAccount(pin);
        if (account != null) {
            User user = new User(account);
            user.displayMenu();
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }
    }
}
