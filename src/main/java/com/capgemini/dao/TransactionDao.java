package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.TransactionEntity;

public interface TransactionDao extends Dao<TransactionEntity, Long> {

	List<Long> returnListClientWithTransactionInDeliver();

}
