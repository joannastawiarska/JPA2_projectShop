package com.capgemini.dao.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.TransactionsDetailsDao;
import com.capgemini.datatype.TransactionType;
import com.capgemini.domain.ProductEntity;
import com.capgemini.domain.QProductEntity;
import com.capgemini.domain.QTransactionEntity;
import com.capgemini.domain.QTransactionsDetailsEntity;
import com.capgemini.domain.TransactionsDetailsEntity;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class TransactionsDetailsImpl extends AbstractDao<TransactionsDetailsEntity, Long>
		implements TransactionsDetailsDao {

	// a
	@Override
	public double countWholePrice(Long transactionId) {

		QTransactionsDetailsEntity details = QTransactionsDetailsEntity.transactionsDetailsEntity;
		QProductEntity product = QProductEntity.productEntity;
		JPAQuery<TransactionsDetailsEntity> query = new JPAQuery<TransactionsDetailsEntity>(entityManager);
		
		return query.select(product.price.multiply(details.large).sum()).from(product, details)
				.where(details.product.id.eq(product.id).and(details.transaction.id.eq(transactionId))).fetchOne();
	}
	
	// d
	@Override
	public List<Long> getThreeClientsWithMostAmountMoney(Date firstDate, Date secondDate) {
		
		QProductEntity product = QProductEntity.productEntity;
		QTransactionEntity transaction = QTransactionEntity.transactionEntity;
		QTransactionsDetailsEntity details = QTransactionsDetailsEntity.transactionsDetailsEntity;
		JPAQuery<ProductEntity> query = new JPAQuery<ProductEntity>(entityManager);
		
		return query.select(transaction.client.id)
				.from(details).innerJoin(details.transaction, transaction).innerJoin(details.product, product)
				.where(transaction.dateOfOrder.before(secondDate).and(transaction.dateOfOrder.after(firstDate)).and(transaction.status.ne(TransactionType.Canceled)))
				.groupBy(transaction.client.id).orderBy((details.large.multiply(product.price).sum().desc())).limit(3).fetch();
	}
	
	// f
	@Override
	public double getProfitOnDate(Date firstDate, Date secondDate){
		
		QProductEntity product = QProductEntity.productEntity;
		QTransactionEntity transaction = QTransactionEntity.transactionEntity;
		QTransactionsDetailsEntity details = QTransactionsDetailsEntity.transactionsDetailsEntity;
		JPAQuery<ProductEntity> query = new JPAQuery<ProductEntity>(entityManager);
		NumberPath<Double> profit = Expressions.numberPath(Double.class, "profit");
		
		return query.select(product.price.multiply((product.margin.divide(100)).multiply(details.large)).sum().as(profit))
				.from(details).innerJoin(details.transaction, transaction).innerJoin(details.product, product)
				.where(transaction.dateOfOrder.before(secondDate).and(transaction.dateOfOrder.after(firstDate))).fetchOne();
	}
}
