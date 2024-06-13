package com.javaded.events;

import com.javaded.domain.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(Object payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
