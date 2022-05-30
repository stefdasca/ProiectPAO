package com.company.exceptions;

public class InsufficientFundsException extends Throwable {
    private int amount;

    public InsufficientFundsException(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
