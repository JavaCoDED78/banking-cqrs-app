package com.javaded.service.card;

import com.javaded.domain.model.Card;
import com.javaded.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.javaded.util.GenerationCardParameters.generateCvv;
import static com.javaded.util.GenerationCardParameters.generateDate;
import static com.javaded.util.GenerationCardParameters.generateNumber;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card create(final Card card) {
        card.setCvv(generateCvv());
        card.setDate(generateDate());
        card.setNumber(generateNumber());
        return cardRepository.save(card);
    }

}
