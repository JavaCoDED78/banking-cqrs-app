package com.javaded.service.account;

import com.javaded.domain.exception.ResourceNotFoundException;
import com.javaded.domain.model.Account;
import com.javaded.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository accountRepository;


    @Override
    public Account getById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
