package com.javaded.web.mapper;

import com.javaded.domain.model.Transaction;
import com.javaded.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
