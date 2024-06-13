package com.javaded.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record CardDto(

        @NotBlank(message = "Id must not be blank.", groups = OnUpdate.class)
        @Null(message = "Id must be null.", groups = OnCreate.class)
        UUID id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String number,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String cvv,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String date,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        List<TransactionDto> transactions,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        AccountDto account
) {
}
