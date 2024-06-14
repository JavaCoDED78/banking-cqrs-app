package com.javaded.web.mapper;

import com.javaded.domain.model.Account;
import com.javaded.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
