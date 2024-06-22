package com.javaded.service.auth;

import com.javaded.domain.exception.ResourceAlreadyExistsException;
import com.javaded.domain.model.Client;
import com.javaded.service.client.ClientService;
import com.javaded.web.dto.LoginRequestDto;
import com.javaded.web.dto.LoginResponseDto;
import com.javaded.web.security.jwt.JwtProperties;
import com.javaded.web.security.jwt.TokenType;
import io.github.javacoded78.jwthumble.config.TokenParameters;
import io.github.javacoded78.jwthumble.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;
    private final TokenService tokenService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(final LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        return LoginResponseDto.builder()
                .accessToken(
                        tokenService.create(
                                TokenParameters.builder(
                                        request.username(),
                                        TokenType.ACCESS.name(),
                                        jwtProperties.getAccess()
                                ).build()
                        )
                )
                .refreshToken(
                        tokenService.create(
                                TokenParameters.builder(
                                        request.username(),
                                        TokenType.REFRESH.name(),
                                        jwtProperties.getRefresh()
                                ).build()
                        )
                )
                .build();
    }

    @Override
    @Transactional
    public void register(final Client client) {
        if (clientService.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }
}
