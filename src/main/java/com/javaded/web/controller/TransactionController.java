package com.javaded.web.controller;

import com.javaded.domain.model.Transaction;
import com.javaded.service.transaction.TransactionService;
import com.javaded.web.dto.OnCreate;
import com.javaded.web.dto.TransactionDto;
import com.javaded.web.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create(@RequestBody @Validated(OnCreate.class) final TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.fromDto(transactionDto);
        transactionService.create(transaction);
    }

    @GetMapping("{/id}")
    public TransactionDto getById(@PathVariable final UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }

}
