package com.javaded.service.event;

import com.javaded.events.AbstractEvent;
import com.javaded.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public void publish(final AbstractEvent event) {
        eventRepository.save(event);
    }
}
