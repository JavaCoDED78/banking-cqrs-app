package com.javaded.service.account;

import com.javaded.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    @Override
    public void create(Account obj) {
        accountCommandService.create(obj);
    }

    @Override
    public Account getById(UUID id) {
        return accountQueryService.getById(id);
    }
}
