package com.bank.transfer.service;

import com.bank.transfer.domain.entity.*;
import com.bank.transfer.dto.*;
import com.bank.transfer.exception.*;
import com.bank.transfer.mapper.TransactionMapper;
import com.bank.transfer.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepo;
    private final TransactionRepository txRepo;

    public TransferServiceImpl(AccountRepository accountRepo,
                               TransactionRepository txRepo) {
        this.accountRepo = accountRepo;
        this.txRepo = txRepo;
    }

    @Override
    public TransferResponseDTO transfer(TransferRequestDTO request) {

        Transaction tx = null;

        try {
            Account from = accountRepo.findById(request.getFromAccountId())
                    .orElseThrow(() -> new AccountNotFoundException(request.getFromAccountId()));

            Account to = accountRepo.findById(request.getToAccountId())
                    .orElseThrow(() -> new AccountNotFoundException(request.getToAccountId()));

            if (!from.isActive() || !to.isActive()) {
                throw new InvalidAccountStateException();
            }

            tx = new Transaction(from.getAccountId(), to.getAccountId(), request.getAmount());
            txRepo.save(tx);

            from.debit(request.getAmount());
            to.credit(request.getAmount());

            accountRepo.save(from);
            accountRepo.save(to);

            tx.markSuccess();
            txRepo.save(tx);

            return TransactionMapper.toResponse(tx);

        } catch (RuntimeException ex) {
            if (tx != null) {
                tx.markFailed();
                txRepo.save(tx);
            }
            throw ex;
        }
    }
}
