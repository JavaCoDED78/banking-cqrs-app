package com.javade.events;

import com.javade.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);
}
