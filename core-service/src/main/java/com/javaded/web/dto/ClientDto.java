package com.javaded.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ClientDto(

        @NotNull(message = "Id must not be blank.", groups = OnUpdate.class)
        @Null(message = "Id must be null.", groups = OnCreate.class)
        UUID id,

        @NotBlank(message = "Name must not be blank.", groups = {OnCreate.class, OnUpdate.class})
        @Size(min = 1,
                max = 255,
                message = "Name must be between {min} and {max} characters in length.",
                groups = {OnCreate.class, OnUpdate.class})
        String name,

        @Email(message = "Email must be a valid email address.")
        @NotBlank(message = "Username must not be blank.", groups = {OnCreate.class, OnUpdate.class})
        @Size(min = 1,
                max = 255,
                message = "Username must be between {min} and {max} characters in length.",
                groups = {OnCreate.class, OnUpdate.class})
        String username,

        @NotBlank(message = "Password must not be blank.", groups = {OnCreate.class, OnUpdate.class})
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password

) {
}
