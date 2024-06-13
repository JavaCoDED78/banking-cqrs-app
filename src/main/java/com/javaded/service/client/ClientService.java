package com.javaded.service.client;

import com.javaded.domain.model.Client;
import com.javaded.service.CommandService;
import com.javaded.service.QueryService;

public interface ClientService extends CommandService<Client>, QueryService<Client> {
}
