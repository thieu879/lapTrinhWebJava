package com.data.ss14.dao.bt9;

import com.data.ss14.model.bt9.Transaction;

import java.util.List;

public interface TransactionDAO {
    void addTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    void deleteTransaction(int index);
}

