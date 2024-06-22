package com.javaded.web.controller;

import com.javaded.domain.exception.ResourceAlreadyExistsException;
import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.web.dto.MessageErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageErrorDto resourceNotFound(final ResourceNotFoundException e) {
        return new MessageErrorDto(e.getMessage() != null
                ? e.getMessage()
                : "Not found."
        );
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageErrorDto resourceAlreadyExists(final ResourceAlreadyExistsException e) {
        return new MessageErrorDto(e.getMessage() != null
                ? e.getMessage()
                : "Already exists."
        );
    }

    @ExceptionHandler({BadCredentialsException.class, InternalAuthenticationServiceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageErrorDto badCredentials(final RuntimeException e) {
        return new MessageErrorDto("Authentication failed.");
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageErrorDto accessDenied(final AccessDeniedException e) {
        return new MessageErrorDto("Access denied.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageErrorDto validation(final MethodArgumentNotValidException e) {
        Map<String, String> errors = e.getBindingResult()
                .getFieldErrors().stream()
                .collect(toMap(
                        FieldError::getField,
                        error -> {
                            String defaultMessage = error.getDefaultMessage();
                            return defaultMessage != null ? defaultMessage : "";
                        },
                        (existingMessage, newMessage) -> existingMessage + " " + newMessage
                ));
        return new MessageErrorDto("Validation failed.", errors);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageErrorDto illegalState(final IllegalStateException e) {
        return new MessageErrorDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageErrorDto exception(final Exception e) {
        e.printStackTrace();
        return new MessageErrorDto("Server error.");
    }

}
