package com.capgemini.dao;

import java.sql.Date;
import java.util.List;

import com.capgemini.domain.TransactionsDetailsEntity;

public interface TransactionsDetailsDao extends Dao<TransactionsDetailsEntity, Long> {

	double countWholePrice(Long transactionId);
	List<Long> getThreeClientsWithMostAmountMoney(Date firstDate, Date secondDate);
	double getProfitOnDate(Date firstDate, Date secondDate);
	
}
