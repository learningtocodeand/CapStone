package com.bank.transfer.controller;

import com.bank.transfer.dto.TransferRequestDTO;
import com.bank.transfer.dto.TransferResponseDTO;
import com.bank.transfer.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
@CrossOrigin
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping
    public TransferResponseDTO transfer(
            @Valid @RequestBody TransferRequestDTO request) {
        return service.transfer(request);
    }
}
