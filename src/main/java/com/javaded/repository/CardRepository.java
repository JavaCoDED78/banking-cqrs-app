package com.javaded.repository;

import com.javaded.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsByNumberAndDate(String number,
                                  String date);


    Optional<Card> findByNumberAndDateAndCvv(String number,
                                             String date,
                                             String cvv);

}
