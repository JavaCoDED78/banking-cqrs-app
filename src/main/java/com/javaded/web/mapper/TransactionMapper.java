package com.javaded.web.mapper;

import com.javaded.domain.model.Transaction;
import com.javaded.web.dto.TransactionDto;
import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = CardMapper.class, injectionStrategy = CONSTRUCTOR)
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
