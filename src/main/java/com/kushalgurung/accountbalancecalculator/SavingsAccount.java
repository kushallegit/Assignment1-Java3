package com.kushalgurung.accountbalancecalculator;

public class SavingsAccount extends Account {
    private double interestRate;
    private double interestPayment;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        interestPayment = getBalance() * interestRate; // Correctly calculating interest
        setBalance(getBalance() + interestPayment);
    }

    public double getInterestPayment() {
        return interestPayment;
    }
}
