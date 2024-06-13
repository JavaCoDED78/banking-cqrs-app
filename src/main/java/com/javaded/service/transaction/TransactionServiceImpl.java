package com.javaded.service.transaction;

import com.javaded.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionCommandService transactionCommandService;
    private final TransactionQueryService transactionQueryService;

    @Override
    public void create(Transaction obj) {
        transactionCommandService.create(obj);
    }

    @Override
    public Transaction getById(UUID id) {
        return transactionQueryService.getById(id);
    }
}
