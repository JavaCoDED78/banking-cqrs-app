package com.javaded.service.account;

import com.javaded.domain.model.Account;
import com.javaded.service.CommandService;
import com.javaded.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
}
