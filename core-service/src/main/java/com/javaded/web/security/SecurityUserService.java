package com.javaded.web.security;

import com.javaded.domain.model.Client;
import com.javaded.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }

}
