package com.javaded.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ClientDto(

        @NotBlank(message = "Id must not be blank.", groups = OnUpdate.class)
        @Null(message = "Id must be null.", groups = OnCreate.class)
        UUID id,

        @NotBlank(message = "Name must not be blank.")
                @Size(min = 1, max = 255, message = "Name must be between {min} and {max} characters in length.")
        String name,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        List<CardDto> cards
) {
}
