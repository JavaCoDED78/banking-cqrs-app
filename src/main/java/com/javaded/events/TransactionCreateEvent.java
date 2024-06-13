package com.javaded.events;

import com.javaded.domain.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(Object payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
