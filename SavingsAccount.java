//package Java3;
import java.util.*;
class SavingsAccount extends BankAccount {
    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }
    @Override
    void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}