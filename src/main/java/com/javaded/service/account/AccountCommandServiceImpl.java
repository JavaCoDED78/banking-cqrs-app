package com.javaded.service.account;

import com.javaded.domain.model.Account;
import com.javaded.events.AccountCreateEvent;
import com.javaded.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(final Account obj) {
        AccountCreateEvent event = new AccountCreateEvent(obj);
        eventService.publish(event);
    }
}
