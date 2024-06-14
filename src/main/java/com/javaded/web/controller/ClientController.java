package com.javaded.web.controller;

import com.javaded.domain.model.Client;
import com.javaded.service.client.ClientService;
import com.javaded.web.dto.AccountDto;
import com.javaded.web.dto.CardDto;
import com.javaded.web.dto.ClientDto;
import com.javaded.web.mapper.AccountMapper;
import com.javaded.web.mapper.CardMapper;
import com.javaded.web.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("{/id}")
    public ClientDto getById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @GetMapping("{/id}/cards")
    public List<CardDto> getCardsById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @GetMapping("{/id}/accounts")
    public AccountDto getAccountById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }

}