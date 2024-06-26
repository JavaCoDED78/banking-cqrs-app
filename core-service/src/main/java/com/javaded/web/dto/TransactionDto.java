package com.javaded.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.groups.ConvertGroup;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record TransactionDto(

        @NotBlank(message = "Id must not be blank.", groups = OnUpdate.class)
        @Null(message = "Id must be null.", groups = OnCreate.class)
        UUID id,

        @NotBlank(message = "Sender card must not be blank.", groups = OnCreate.class)
        @Valid
        @ConvertGroup(from = OnCreate.class, to = OnTransactionFrom.class)
        CardDto from,

        @NotBlank(message = "Receiver card must not be blank.", groups = OnCreate.class)
        @Valid
        @ConvertGroup(from = OnCreate.class, to = OnTransactionFrom.class)
        CardDto to,

        @NotBlank(message = "Amount must not be blank.", groups = OnCreate.class)
        @Positive(message = "Amount must be positive.", groups = OnCreate.class)
        BigDecimal amount
) {
}
