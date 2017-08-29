package com.capgemini.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.ProductDao;
import com.capgemini.datatype.TransactionType;
import com.capgemini.domain.ProductEntity;
import com.capgemini.domain.QProductEntity;
import com.capgemini.domain.QTransactionEntity;
import com.capgemini.domain.QTransactionsDetailsEntity;
import com.capgemini.domain.TransactionsDetailsEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class ProductDaoImpl extends AbstractDao<ProductEntity, Long> implements ProductDao {

	// c
	@Override
	public List<Long> findTenTheBestOfProducts() {

		QTransactionsDetailsEntity details = QTransactionsDetailsEntity.transactionsDetailsEntity;
		QTransactionEntity transaction = QTransactionEntity.transactionEntity;
		JPAQuery<TransactionsDetailsEntity> query = new JPAQuery<TransactionsDetailsEntity>(entityManager);

		return query.select(details.product.id).from(details).join(details.transaction, transaction)
				.where(transaction.status.ne(TransactionType.Canceled)).groupBy(details.product.id)
				.orderBy(details.product.id.count().desc()).limit(10).fetch();

	}

	// e
	@Override
	public Map<String, Integer> findProductsInProgress() {

		QProductEntity product = QProductEntity.productEntity;
		QTransactionEntity transaction = QTransactionEntity.transactionEntity;
		QTransactionsDetailsEntity details = QTransactionsDetailsEntity.transactionsDetailsEntity;
		JPAQuery<ProductEntity> query = new JPAQuery<ProductEntity>(entityManager);
		NumberPath<Integer> suma = Expressions.numberPath(Integer.class, "suma");

		List<Tuple> result = query.select(product.name, details.large.sum().as(suma)).from(details)
				.innerJoin(details.transaction, transaction).innerJoin(details.product, product)
				.where(transaction.status.eq(TransactionType.InProgress)).groupBy(product.id).fetch();
		
		return result.stream().collect(Collectors.toMap(p -> p.get(product.name), p -> p.get(suma)));
	}

	// b
	public List<Long> findUniqueBoughtProductsOfClient(Long clientId) {

		QTransactionEntity transaction = QTransactionEntity.transactionEntity;
		QTransactionsDetailsEntity details = QTransactionsDetailsEntity.transactionsDetailsEntity;
		JPAQuery<ProductEntity> query = new JPAQuery<ProductEntity>(entityManager);

		return query.select(details.product.id).from(details).innerJoin(details.transaction, transaction)
				.where(transaction.client.id.eq(clientId)).groupBy(details.product.id).fetch();

	}
}
