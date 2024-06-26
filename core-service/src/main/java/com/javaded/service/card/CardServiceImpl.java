package com.javaded.service.card;

import com.javaded.domain.model.Card;
import com.javaded.domain.model.Client;
import com.javaded.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardCommandService cardCommandService;
    private final CardQueryService cardQueryService;
    private final ClientService clientService;

    @Override
    public void create(final Card obj) {
        cardCommandService.create(obj);
    }

    @Override
    public Card getById(final UUID id) {
        return cardQueryService.getById(id);
    }

    @Override
    public void createByClientId(final UUID clientId) {
        Client client = clientService.getById(clientId);
        Card card = new Card(client.getAccount());
        cardCommandService.create(card);
    }

    @Override
    public boolean existsByNumberAndDate(final String number,
                                         final String date) {
        return cardQueryService.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(final String number,
                                         final String date,
                                         final String cvv) {
        return cardQueryService.getByNumberAndDateAndCvv(number, date, cvv);
    }

    @Override
    public Card getByNumberAndDate(final String number,
                                   final String date) {
        return cardQueryService.getByNumberAndDate(number, date);
    }

}
