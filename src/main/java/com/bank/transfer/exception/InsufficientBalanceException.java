package com.bank.transfer.exception;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String accID){
        System.out.println(accID + "has Insufficient balance.");
    }
}
