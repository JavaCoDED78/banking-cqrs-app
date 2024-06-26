package com.javaded.service.card;

import com.javaded.domain.model.Card;
import com.javaded.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number,
                                  String date);

    Card getByNumberAndDateAndCvv(String number,
                                  String date,
                                  String cvv);

    Card getByNumberAndDate(String number,
                            String date);
}
