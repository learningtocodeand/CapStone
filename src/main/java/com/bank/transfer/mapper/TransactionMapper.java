package com.bank.transfer.mapper;

import com.bank.transfer.domain.entity.Transaction;
import com.bank.transfer.dto.TransferResponseDTO;

public class TransactionMapper {

    public static TransferResponseDTO toResponse(Transaction tx) {
        return new TransferResponseDTO(
                tx.getTransactionId(),
                tx.getStatus(),
                tx.getCreatedAt()
        );
    }
}
