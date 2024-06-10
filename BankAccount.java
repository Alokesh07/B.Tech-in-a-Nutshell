//package Java3;
import java.util.Scanner;

abstract class BankAccount {
    protected double balance;

    abstract void deposit(double amount);
    abstract void withdraw(double amount);
}