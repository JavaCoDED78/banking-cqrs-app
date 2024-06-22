package com.javaded.service.auth;

import com.javaded.domain.model.Client;
import com.javaded.web.dto.LoginRequestDto;
import com.javaded.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    void register(Client client);
}
