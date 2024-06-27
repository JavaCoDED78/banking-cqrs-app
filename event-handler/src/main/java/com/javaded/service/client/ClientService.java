package com.javaded.service.client;

import com.javaded.domain.model.Client;

import java.util.UUID;

public interface ClientService {

    Client create(Client client);

    void addCard(UUID clientId,
                 UUID cardId);

}
