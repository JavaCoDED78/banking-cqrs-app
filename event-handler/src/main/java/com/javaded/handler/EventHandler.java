package com.javaded.handler;

import com.google.gson.JsonObject;
import org.springframework.kafka.support.Acknowledgment;

public interface EventHandler {

    void handle(JsonObject object,
                Acknowledgment acknowledgment);

}
