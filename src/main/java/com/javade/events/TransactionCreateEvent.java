package com.javade.events;

import com.javade.domain.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionCreateEvent extends AbstractEvent {

    @Override
    public void apply(Aggregate aggregate) {

    }
}
