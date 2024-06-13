package com.javaded.events;

import com.javaded.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);
}
