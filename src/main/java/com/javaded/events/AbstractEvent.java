package com.javaded.events;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractEvent implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID aggregateId;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private LocalDateTime timestamp = LocalDateTime.now();

    @JdbcTypeCode(org.hibernate.type.SqlTypes.JSON)
    private Object payload;

    public AbstractEvent(final UUID aggregateId, final EventType type, final Object payload) {
        this.aggregateId = aggregateId;
        this.type = type;
        this.payload = payload;
    }
}
