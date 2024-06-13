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
    public void create(Client obj) {
        clientCommandService.create(obj);
    }

    @Override
    public Client getById(UUID id) {
        return clientQueryService.getById(id);
    }
}
