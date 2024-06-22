package com.javaded.web.security.service;

import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.domain.model.Card;
import com.javaded.domain.model.Client;
import com.javaded.domain.model.Transaction;
import com.javaded.service.card.CardService;
import com.javaded.service.client.ClientService;
import com.javaded.service.transaction.TransactionService;
import com.javaded.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final ClientService clientService;
    private final CardService cardService;
    private final TransactionService transactionService;

    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (SecurityUser) authentication.getPrincipal();
    }

    @Override
    public boolean canAccessClient(final UUID clientId) {
        SecurityUser user = getUserFromRequest();
        return clientId.equals(user.getId());
    }

    @Override
    public boolean canAccessCard(final UUID cardId) {
        SecurityUser user = getUserFromRequest();
        Client client = clientService.getById(user.getId());
        return client.getCards().stream().anyMatch(card -> card.getId().equals(cardId));
        // TODO implement from check in db
    }

    @Override
    public boolean canAccessCard(final Card card) {
        try {
            Card maybeCard = cardService.getByNumberAndDateAndCvv(
                    card.getNumber(),
                    card.getDate(),
                    card.getCvv()
            );
            return canAccessCard(maybeCard.getId());
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(final UUID transactionId) {
        SecurityUser user = getUserFromRequest();
        Client client = clientService.getById(user.getId());
        Transaction transaction = transactionService.getById(transactionId);
        return client.getCards().contains(transaction.getFrom())
               || client.getCards().contains(transaction.getTo());
        // TODO optimise code
    }

}
