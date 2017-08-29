package com.capgemini.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.TransactionDao;
import com.capgemini.datatype.TransactionType;
import com.capgemini.domain.QTransactionEntity;
import com.capgemini.domain.QTransactionsDetailsEntity;
import com.capgemini.domain.TransactionEntity;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class TransactionDaoImpl extends AbstractDao<TransactionEntity, Long> implements TransactionDao {

	// g
	@Override
	public List<Long> returnListClientWithTransactionInDeliver() {

		QTransactionEntity transaction = QTransactionEntity.transactionEntity;
		QTransactionsDetailsEntity details = QTransactionsDetailsEntity.transactionsDetailsEntity;
		JPAQuery<TransactionEntity> query = new JPAQuery<TransactionEntity>(entityManager);

		return query.select(transaction.client.id).from(details).join(details.transaction, transaction)
				.where(transaction.status.eq(TransactionType.InDeliver)).groupBy(transaction.client.id).fetch();
	}
}