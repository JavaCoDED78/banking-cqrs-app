package com.javaded.web.dto;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public record MessageErrorDto(

        String message,
        Map<String, String> errors
) {

    public MessageErrorDto(final String message) {
        this(message, new HashMap<>());
    }

}
