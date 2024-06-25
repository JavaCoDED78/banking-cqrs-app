package com.javaded.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CardDto(

        @NotBlank(message = "Id must not be blank.", groups = OnUpdate.class)
        @Null(message = "Id must be null.", groups = OnCreate.class)
        UUID id,

        @NotBlank(message = "Number must not be blank.", groups = OnCreate.class)
        String number,

        @NotBlank(message = "Cvv must not be blank.", groups = OnCreate.class)
        String cvv,

        @NotBlank(message = "Date must not be blank.", groups = OnCreate.class)
        String date

) {
}