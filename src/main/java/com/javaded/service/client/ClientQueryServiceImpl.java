package com.javaded.service.client;

import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.domain.model.Client;
import com.javaded.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository clientRepository;

    @Override
    public Client getById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
