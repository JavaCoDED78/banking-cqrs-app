package com.javaded.service.transaction;

import com.javaded.domain.model.Card;
import com.javaded.domain.model.Transaction;
import com.javaded.repository.TransactionRepository;
import com.javaded.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardService cardService;

    @Override
    @Transactional
    public Transaction create(final Transaction transaction) {
        Card cardFrom = cardService.getById(transaction.getFrom().getId());
        Card cardTo = cardService.getById(transaction.getTo().getId());
        checkBalance(cardFrom, transaction.getAmount());
        cardService.add(cardFrom, transaction.getAmount().negate());
        cardService.add(cardTo, transaction.getAmount());
        return transactionRepository.save(transaction);
    }

    private void checkBalance(final Card card,
                              final BigDecimal amount) {
        if (card.getAccount().getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money on card account.");
        }
    }

}
