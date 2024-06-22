package com.javaded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
public class BankingCqrsAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BankingCqrsAppApplication.class, args);
    }

}
