//package Java3;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose account type (1. Savings, 2. Current): ");
        int accountType = scanner.nextInt();

        BankAccount account;

        switch (accountType) {
            case 1:
                account = new SavingsAccount();
                break;
            case 2:
                account = new CurrentAccount();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        System.out.print("Enter initial balance: ");
        account.balance = scanner.nextDouble();

        System.out.print("Choose operation (1. Deposit, 2. Withdraw): ");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
        }

        scanner.close();
    }
}