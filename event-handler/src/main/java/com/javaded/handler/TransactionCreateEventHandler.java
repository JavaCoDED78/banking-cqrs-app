package com.javaded.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.javaded.domain.model.Transaction;
import com.javaded.events.TransactionCreateEvent;
import com.javaded.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler {

    private final TransactionService transactionService;
    private final Gson gson;

    @Override
    public void handle(final JsonObject object,
                       final Acknowledgment acknowledgment) {
        Gson gson = new Gson();
        TransactionCreateEvent event = gson.fromJson(object, TransactionCreateEvent.class);
        Transaction transaction = gson.fromJson((String) event.getPayload(), Transaction.class);
        transactionService.create(transaction);
        acknowledgment.acknowledge();
    }

}
