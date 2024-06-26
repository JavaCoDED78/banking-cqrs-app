package com.javaded.service.transaction;

import com.javaded.domain.model.Card;
import com.javaded.domain.model.Transaction;
import com.javaded.events.TransactionCreateEvent;
import com.javaded.service.card.CardService;
import com.javaded.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;
    private final CardService cardService;

    @Override
    public void create(final Transaction obj) {
        Card from = cardService.getByNumberAndDateAndCvv(
                obj.getFrom().getNumber(),
                obj.getFrom().getDate(),
                obj.getFrom().getCvv()
        );
        Card to = cardService.getByNumberAndDate(
                obj.getTo().getNumber(),
                obj.getTo().getDate()
        );
        obj.setFrom(from);
        obj.setTo(to);
        TransactionCreateEvent event = new TransactionCreateEvent(obj);
        eventService.publish(event);
    }
}
