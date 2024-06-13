package com.javaded.service.transaction;

import com.javaded.domain.model.Transaction;
import com.javaded.events.TransactionCreateEvent;
import com.javaded.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(Transaction obj) {
        TransactionCreateEvent event = new TransactionCreateEvent(obj);
        eventService.publish(event);
    }
}
