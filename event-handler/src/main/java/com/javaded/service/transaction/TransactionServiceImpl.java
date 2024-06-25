package com.javaded.service.transaction;

import com.javaded.domain.model.Transaction;
import com.javaded.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction create(final Transaction transaction) {
        //TODO change balance of card accounts
        return transactionRepository.save(transaction);
    }

}
