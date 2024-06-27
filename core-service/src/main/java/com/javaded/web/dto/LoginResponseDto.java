package com.javaded.web.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record LoginResponseDto(

        UUID id,
        String accessToken,
        String refreshToken
) {
}
