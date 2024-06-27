package com.javaded.service.card;


import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.domain.model.Card;
import com.javaded.domain.model.Client;
import com.javaded.repository.CardRepository;
import com.javaded.service.client.ClientQueryService;
import com.javaded.service.client.ClientService;
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
    private final ClientQueryService clientQueryService;
    private final ClientService clientService;

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
        cardRepository.saveAndFlush(card);
        Client client = clientQueryService.getByAccount(card.getAccount().getId());
        clientService.addCard(client.getId(), card.getId());
        return card;
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

    @Override
    @Transactional
    public void addTransaction(final UUID cardId,
                               final UUID transactionId) {
        cardRepository.addTransaction(
                cardId.toString(),
                transactionId.toString()
        );
    }

}
