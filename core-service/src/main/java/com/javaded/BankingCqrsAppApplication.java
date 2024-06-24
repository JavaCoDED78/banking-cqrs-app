package com.javaded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@EntityScan(basePackages = "com.javaded")
@ComponentScan(basePackages = "com.javaded")
@EnableJpaRepositories(basePackages = "com.javaded.*")
public class BankingCqrsAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BankingCqrsAppApplication.class, args);
    }

}
