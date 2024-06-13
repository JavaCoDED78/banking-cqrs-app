package com.javaded.service.card;

import com.javaded.domain.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardCommandService cardCommandService;
    private final CardQueryService cardQueryService;

    @Override
    public void create(Card obj) {
        cardCommandService.create(obj);
    }

    @Override
    public Card getById(UUID id) {
        return cardQueryService.getById(id);
    }
}
