package com.javaded.events;

import com.javaded.domain.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardCreateEvent extends AbstractEvent {

    public CardCreateEvent(final Object payload) {
        super(null, EventType.CARD_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}
