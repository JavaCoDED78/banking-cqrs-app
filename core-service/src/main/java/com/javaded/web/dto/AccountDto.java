package com.javaded.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record AccountDto(

        @NotNull(message = "Id must not be blank.", groups = OnUpdate.class)
        @Null(message = "Id must be null.", groups = OnCreate.class)
        UUID id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String number,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        BigDecimal balance

) {
}
