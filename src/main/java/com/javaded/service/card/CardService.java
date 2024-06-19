package com.javaded.service.card;

import com.javaded.domain.model.Card;
import com.javaded.service.CommandService;
import com.javaded.service.QueryService;

import java.util.UUID;

public interface CardService extends CommandService<Card>, QueryService<Card> {

    void createByClientId(UUID clientId);

    boolean existsByNumberAndDate(String number,
                                  String date);

    Card getByNumberAndDateAndCvv(String number,
                                  String date,
                                  String cvv);
}
