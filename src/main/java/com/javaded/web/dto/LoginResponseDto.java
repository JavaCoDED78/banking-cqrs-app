package com.javaded.web.dto;

import lombok.Builder;

@Builder
public record LoginResponseDto(

        String accessToken,
        String refreshToken
) {
}
