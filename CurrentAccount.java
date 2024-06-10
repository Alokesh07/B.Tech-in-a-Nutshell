//package Java3;
import java.util.*;
class CurrentAccount extends BankAccount {
    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    @Override
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawal successful. Current balance: " + balance);
    }
}