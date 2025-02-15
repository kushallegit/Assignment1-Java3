package com.kushalgurung.accountbalancecalculator;

import java.util.Scanner;

public class AccountBalanceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initializing accounts
        ChequingAccount chequingAccount = new ChequingAccount(1000.00, 1.00);  // $1 monthly fee
        SavingsAccount savingsAccount = new SavingsAccount(1000.00, 0.01);  // 1% interest

        // Display starting balances
        System.out.println("Welcome to the Account application");
        System.out.println("\nStarting Balances:");
        System.out.printf("Checking: $%,.2f\n", chequingAccount.getBalance());
        System.out.printf("Savings: $%,.2f\n", savingsAccount.getBalance());

        // Transaction processing loop
        boolean continueTransactions = true;
        while (continueTransactions) {
            System.out.println("\nEnter the transactions for the month");

            System.out.print("Withdrawal or deposit? (w/d): ");
            String transactionType = scanner.nextLine().trim().toLowerCase();

            if (!transactionType.equals("w") && !transactionType.equals("d")) {
                System.out.println("Invalid input. Enter 'w' for withdrawal or 'd' for deposit.");
                continue;
            }

            System.out.print("Checking or savings? (c/s): ");
            String accountType = scanner.nextLine().trim().toLowerCase();

            if (!accountType.equals("c") && !accountType.equals("s")) {
                System.out.println("Invalid input. Enter 'c' for checking or 's' for savings.");
                continue;
            }

            System.out.print("Amount?: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Enter a numeric value.");
                continue;
            }

            if (transactionType.equals("w")) {
                if (accountType.equals("c")) {
                    chequingAccount.withdraw(amount);
                } else {
                    savingsAccount.withdraw(amount);
                }
            } else {
                if (accountType.equals("c")) {
                    chequingAccount.deposit(amount);
                } else {
                    savingsAccount.deposit(amount);
                }
            }

            // Asking if user wants to continue transactions
            System.out.print("\nContinue? (y/n): ");
            String continueTransaction = scanner.nextLine().trim().toLowerCase();
            if (continueTransaction.equals("n")) {
                continueTransactions = false;  // Properly exit loop
            }
        }

        // Apply monthly fees and interest
        chequingAccount.subtractMonthlyFee();
        savingsAccount.applyInterest();

        // Display monthly payments, fees, and final balances
        System.out.println("\nMonthly Payments and Fees");
        System.out.printf("Checking fee: $%,.2f\n", chequingAccount.getMonthlyFee());
        System.out.printf("Savings interest payment: $%,.2f\n", savingsAccount.getInterestPayment());

        System.out.println("\nFinal Balances");
        System.out.printf("Checking: $%,.2f\n", chequingAccount.getBalance());
        System.out.printf("Savings: $%,.2f\n", savingsAccount.getBalance());

        scanner.close();
    }
}
