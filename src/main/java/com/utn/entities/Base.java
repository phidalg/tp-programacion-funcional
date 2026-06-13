package com.utn.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public abstract class Base {

    private static final AtomicLong COUNTER = new AtomicLong(100_000L);

    private final Long id = COUNTER.incrementAndGet();
    private boolean eliminado;
    private final LocalDateTime createdAt = LocalDateTime.now();

}
