package com.javaded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BankingCqrsAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BankingCqrsAppApplication.class, args);
    }

}
