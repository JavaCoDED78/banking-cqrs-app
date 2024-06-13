package com.javaded.service.card;

import com.javaded.domain.model.Card;
import com.javaded.service.CommandService;
import com.javaded.service.QueryService;

public interface CardService extends CommandService<Card>, QueryService<Card> {
}
