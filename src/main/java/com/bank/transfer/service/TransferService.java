package com.bank.transfer.service;

import com.bank.transfer.dto.TransferRequestDTO;
import com.bank.transfer.dto.TransferResponseDTO;

public interface TransferService {
    TransferResponseDTO transfer(TransferRequestDTO request);
}

