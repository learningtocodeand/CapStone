package com.bank.transfer.dto;

import com.bank.transfer.domain.enums.TransactionStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransferResponseDTO {

    private String transactionId;
    private TransactionStatus status;
    private LocalDateTime timestamp;
}
