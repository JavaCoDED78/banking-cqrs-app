package com.javaded.web.security.service;

import com.javaded.domain.model.Card;
import com.javaded.web.dto.CardDto;
import com.javaded.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(CardDto card);

    boolean canAccessTransaction(UUID transactionId);
}
