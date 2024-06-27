package com.javaded.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.javaded.domain.model.Account;
import com.javaded.events.AccountCreateEvent;
import com.javaded.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;
    private final Gson gson;

    @Override

    public void handle(final JsonObject object,
                       final Acknowledgment acknowledgment) {
        AccountCreateEvent event = gson.fromJson(object, AccountCreateEvent.class);
        Account account = gson.fromJson((String) event.getPayload(), Account.class);
        accountService.create(account);
        acknowledgment.acknowledge();
    }

}
