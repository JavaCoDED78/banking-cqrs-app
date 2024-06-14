package com.javaded.service.account;

import com.javaded.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService accountQueryService;

    @Override
    public Account getById(final UUID id) {
        return accountQueryService.getById(id);
    }
}
