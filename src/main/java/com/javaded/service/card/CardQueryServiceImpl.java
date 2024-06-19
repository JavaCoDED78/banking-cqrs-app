package com.javaded.service.card;

import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.domain.model.Card;
import com.javaded.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository cardRepository;

    @Override
    public Card getById(final UUID id) {
        return cardRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }


    @Override
    public boolean existsByNumberAndDate(final String number,
                                         final String date) {
        return cardRepository.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(final String number,
                                          final String date,
                                          final String cvv) {
        return cardRepository.findByNumberAndDateAndCvv(number, date, cvv)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
