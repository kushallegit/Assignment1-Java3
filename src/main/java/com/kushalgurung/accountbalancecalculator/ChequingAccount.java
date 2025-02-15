package com.kushalgurung.accountbalancecalculator;

public class ChequingAccount extends Account {
    private double monthlyFee;

    public ChequingAccount(double initialBalance, double monthlyFee) {
        super(initialBalance);
        this.monthlyFee = monthlyFee;
    }

    public void subtractMonthlyFee() {
        setBalance(getBalance() - monthlyFee);
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}
