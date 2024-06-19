package com.javaded.service.card;

import com.javaded.domain.model.Card;
import com.javaded.events.CardCreateEvent;
import com.javaded.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(final Card obj) {
        CardCreateEvent event = new CardCreateEvent(obj);
        eventService.publish(event);
    }
}
