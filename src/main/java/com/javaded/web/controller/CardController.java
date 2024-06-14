package com.javaded.web.controller;

import com.javaded.domain.model.Card;
import com.javaded.service.card.CardService;
import com.javaded.web.dto.CardDto;
import com.javaded.web.dto.TransactionDto;
import com.javaded.web.mapper.CardMapper;
import com.javaded.web.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        //TODO take client from token
        UUID userId = UUID.randomUUID();
        cardService.createByClientId(userId);
    }

    @GetMapping("{/id}")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("{id}/transactions")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}
