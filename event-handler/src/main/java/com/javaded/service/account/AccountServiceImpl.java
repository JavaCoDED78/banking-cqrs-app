package com.javaded.service.account;

import com.javaded.domain.model.Account;
import com.javaded.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public Account create(final Account account) {
        account.setBalance(BigDecimal.ZERO);
        account.setNumber(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }

}
