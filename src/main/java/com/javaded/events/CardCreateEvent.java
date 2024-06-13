package com.javaded.events;

import com.javaded.domain.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardCreateEvent extends AbstractEvent {

    @Override
    public void apply(Aggregate aggregate) {

    }
}
