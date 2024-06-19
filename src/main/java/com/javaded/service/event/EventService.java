package com.javaded.service.event;

import com.javaded.events.AbstractEvent;

public interface EventService {

    void publish(AbstractEvent event);
}
