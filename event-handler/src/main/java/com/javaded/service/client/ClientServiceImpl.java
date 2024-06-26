package com.javaded.service.client;

import com.javaded.domain.model.Account;
import com.javaded.domain.model.Client;
import com.javaded.repository.ClientRepository;
import com.javaded.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AccountService accountService;

    @Override
    @Transactional
    public Client create(final Client client) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);
        return clientRepository.save(client);
    }
}
