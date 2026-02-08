package com.bank.transfer.domain.entity;

import com.bank.transfer.domain.enums.TransactionStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private String transactionId;

    @Column(name = "from_account", nullable = false)
    private String fromAccount;

    @Column(name = "to_account", nullable = false)
    private String toAccount;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // REQUIRED by JPA
    protected Transaction() {
    }

    // Business constructor
    public Transaction(String fromAccount, String toAccount, BigDecimal amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.status = TransactionStatus.INITIATED;
        this.createdAt = LocalDateTime.now();
    }

    // Getters only (immutable entity style)
    public String getTransactionId() {
        return transactionId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void markSuccess() {
        this.status = TransactionStatus.SUCCESS;
    }

    public void markFailed() {
        this.status = TransactionStatus.FAILED;
    }
}
