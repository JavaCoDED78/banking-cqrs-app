package com.javaded.service.card;


import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.domain.model.Card;
import com.javaded.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

import static com.javaded.util.GenerationCardParameters.generateCvv;
import static com.javaded.util.GenerationCardParameters.generateDate;
import static com.javaded.util.GenerationCardParameters.generateNumber;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card getById(final UUID id) {
        return cardRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Card create(final Card card) {
        card.setCvv(generateCvv());
        card.setDate(generateDate());
        card.setNumber(generateNumber());
        return cardRepository.save(card);
    }

    @Override
    @Transactional
    public void add(final Card card,
                    final BigDecimal amount) {
        card.getAccount().setBalance(
                card.getAccount().getBalance().add(amount)
        );
        cardRepository.save(card);
    }

}
