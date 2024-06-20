package com.javaded.web.controller;

import com.javaded.domain.model.Client;
import com.javaded.service.auth.AuthService;
import com.javaded.web.dto.ClientDto;
import com.javaded.web.dto.LoginRequestDto;
import com.javaded.web.dto.LoginResponseDto;
import com.javaded.web.dto.OnCreate;
import com.javaded.web.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody @Validated final LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) final ClientDto clientDto) {
        Client client = clientMapper.fromDto(clientDto);
        authService.register(client);
    }
}
