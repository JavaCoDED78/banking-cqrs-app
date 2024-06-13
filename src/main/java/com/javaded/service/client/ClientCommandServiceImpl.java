package com.javaded.service.client;

import com.javaded.domain.model.Client;
import com.javaded.events.ClientCreateEvent;
import com.javaded.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(Client obj) {
        ClientCreateEvent event = new ClientCreateEvent(obj);
        eventService.publish(event);
    }
}
