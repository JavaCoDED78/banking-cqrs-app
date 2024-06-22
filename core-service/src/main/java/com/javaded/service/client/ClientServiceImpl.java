package com.javaded.service.client;

import com.javaded.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientCommandService clientCommandService;
    private final ClientQueryService clientQueryService;

    @Override
    public void create(final Client obj) {
        clientCommandService.create(obj);
    }

    @Override
    public Client getById(final UUID id) {
        return clientQueryService.getById(id);
    }

    @Override
    public Client getByUsername(final String username) {
        return clientQueryService.getByUsername(username);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return clientQueryService.existsByUsername(username);
    }
}
