package com.bank.transfer.domain.entity;

import com.bank.transfer.domain.enums.AccountStatus;
import com.bank.transfer.exception.InsufficientBalanceException;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_id")
    private String accountId;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    protected Account() {}

    public Account(String accountId, BigDecimal balance, AccountStatus status) {
        this.accountId = accountId;
        this.balance = balance;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isActive() {
        return status == AccountStatus.ACTIVE;
    }

    public void debit(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException(accountId);
        }
        balance = balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}
