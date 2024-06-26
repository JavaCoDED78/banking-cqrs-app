package com.javaded.service.card;

import com.javaded.domain.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardService {

    Card create(Card card);

    void add(Card card, BigDecimal amount);

    Card getById(UUID id);

}
