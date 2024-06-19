package com.javaded.service.transaction;

import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.domain.model.Transaction;
import com.javaded.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction getById(final UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
