package com.javaded.service.client;

import com.javaded.domain.model.Client;
import com.javaded.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    Client getByUsername(String username);

    boolean existsByUsername(String username);

}
