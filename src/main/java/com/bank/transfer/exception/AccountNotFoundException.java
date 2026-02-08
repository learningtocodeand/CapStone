package com.bank.transfer.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String accID){
        System.out.println(accID + "not found.");
    }
}
