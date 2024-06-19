package com.javaded.web.dto;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public record MessageDto(

        String message,
        Map<String, String> errors
) {

    public MessageDto(final String message) {
        this(message, new HashMap<>());
    }

}
