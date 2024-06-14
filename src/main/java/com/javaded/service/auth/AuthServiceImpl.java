package com.javaded.service.auth;

import com.javaded.domain.model.Client;
import com.javaded.service.client.ClientService;
import com.javaded.web.dto.LoginRequestDto;
import com.javaded.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;

    @Override
    public LoginResponseDto login(final LoginRequestDto request) {
        return null;
    }

    @Override
    public void register(final Client client) {
        clientService.create(client);
    }
}
