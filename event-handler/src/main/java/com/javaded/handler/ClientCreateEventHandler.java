package com.javaded.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.javaded.domain.model.Client;
import com.javaded.events.ClientCreateEvent;
import com.javaded.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService clientService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(final JsonObject object,
                       final Acknowledgment acknowledgment) {
        ClientCreateEvent event = gson.fromJson(object, ClientCreateEvent.class);
        Client client = gson.fromJson((String) event.getPayload(), Client.class);
        clientService.create(client);
        acknowledgment.acknowledge();
    }

}
