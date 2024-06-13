package com.javaded.service.transaction;

import com.javaded.domain.model.Transaction;
import com.javaded.service.CommandService;
import com.javaded.service.QueryService;

public interface TransactionService extends CommandService<Transaction>, QueryService<Transaction> {
}
