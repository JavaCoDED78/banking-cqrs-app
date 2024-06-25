package com.javaded.service.card;

import com.javaded.domain.model.Card;
import com.javaded.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card create(final Card card) {
        //TODO set date cvv and number
        return cardRepository.save(card);
    }

}
