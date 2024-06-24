package com.javaded.events;

import com.javaded.domain.aggregate.Aggregate;
import com.javaded.domain.model.Transaction;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(final Transaction payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
//        TODO implement
    }
}
