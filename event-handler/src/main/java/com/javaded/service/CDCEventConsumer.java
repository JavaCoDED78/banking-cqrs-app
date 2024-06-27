package com.javaded.service;

import org.springframework.kafka.support.Acknowledgment;

public interface CDCEventConsumer {

    void process(String message,
                 Acknowledgment acknowledgment);

}
