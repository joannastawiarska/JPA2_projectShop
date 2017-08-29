package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONS_DETAILS")
public class TransactionsDetailsEntity extends AbstractEntity {

	@ManyToOne
	@JoinColumn
	private TransactionEntity transaction;
	
	@ManyToOne
	@JoinColumn
	private ProductEntity product;
	
	@Column(nullable = false, length = 6)
    private int large;

	public TransactionEntity getTransacion() {
		return transaction;
	}

	public void setTransacion(TransactionEntity transacion) {
		this.transaction = transacion;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getLarge() {
		return large;
	}

	public void setLarge(int large) {
		this.large = large;
	}
	
	
	
}
