package com.javaded.events;

import com.javaded.domain.aggregate.Aggregate;
import com.javaded.domain.model.Account;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountCreateEvent extends AbstractEvent {

    public AccountCreateEvent(final Account payload) {
        super(null, EventType.ACCOUNT_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
        // TODO implement
    }
}
